package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.ItaTacticalReport;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.persistence.repo.ItaTacticalReportRepository;
import ua.softserve.service.AcademyService;
import ua.softserve.service.ItaTacticalReportService;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import static ua.softserve.persistence.constants.ConstantsFromDb.*;
import static ua.softserve.persistence.constants.ConstantsFromDb.ACADEMY_STAGE_BOARDING_ID;

@Service
public class ItaTacticalReportImpl implements ItaTacticalReportService {
    @Autowired
    private ItaTacticalReportRepository itaTacticalReportRepository;
    @Autowired
    private AcademyRepository academyRepository;

    private final Map<String, Predicate<Academy>> FITERS_FOR_REPORTS;

    {
        FITERS_FOR_REPORTS = new HashMap<>();
        FITERS_FOR_REPORTS.put("List of planned launches of group (next 2 monthes)", a -> {
            Calendar dateForComparison = new GregorianCalendar();
            dateForComparison.add(Calendar.MONTH, 2);
            Calendar academyStartDate = new GregorianCalendar();
            academyStartDate.setTimeInMillis(a.getStartDate().getTime());
            return a.getAcademyStages().getStageId() == ACADEMY_STAGE_PLANNED_ID
                    && academyStartDate.before(dateForComparison);
        });
        FITERS_FOR_REPORTS.put("In Process", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_IN_PROCESS_ID);
        FITERS_FOR_REPORTS.put("Offering", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_OFFERING_ID);
        FITERS_FOR_REPORTS.put("Graduated", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_GRADUATED_ID);
        FITERS_FOR_REPORTS.put("List of planned releases", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_BOARDING_ID);
    }

    @Override
    public List<ItaTacticalReport> generateItaTacticalReport() {
        List<ItaTacticalReport> itaTacticalReport = new LinkedList<>();
        List<Academy> academies = academyRepository.findAll();
        for (String reportName : FITERS_FOR_REPORTS.keySet()) {
            List<Integer> ids = academies.stream()
                    .filter(FITERS_FOR_REPORTS.get(reportName))
                    .map(Academy::getAcademyId)
                    .collect(Collectors.toList());
            itaTacticalReportRepository.findAllByAcademyIdIn(ids).stream()
                    .forEach(oneRow -> {
                        oneRow.setReportName(reportName);
                        itaTacticalReport.add(oneRow);
                    });
        }
        return itaTacticalReport;
    }

}
