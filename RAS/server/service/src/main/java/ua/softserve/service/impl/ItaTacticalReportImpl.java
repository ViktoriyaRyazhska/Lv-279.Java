package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.ItaTacticalReport;
import ua.softserve.persistence.repo.ItaTacticalReportRepository;
import ua.softserve.service.AcademyService;
import ua.softserve.service.ItaTacticalReportService;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ua.softserve.persistence.constants.ConstantsFromDb.*;
import static ua.softserve.persistence.constants.ConstantsFromDb.ACADEMY_STAGE_BOARDING_ID;

@Service
public class ItaTacticalReportImpl implements ItaTacticalReportService {
    @Autowired
    private ItaTacticalReportRepository itaTacticalReportRepository;
    @Autowired
    private AcademyService academyService;

    private final Map<String, Predicate<Academy>> FITERS_FOR_REPORTS;
    {
        FITERS_FOR_REPORTS = new HashMap<>();
        FITERS_FOR_REPORTS.put("list_of_planned_next_2_monthes", a -> {
            Calendar dateForComparison = new GregorianCalendar();
            dateForComparison.add(Calendar.MONTH, 2);
            Calendar academyStartDate = new GregorianCalendar();
            academyStartDate.setTimeInMillis(a.getStartDate().getTime());
            return a.getAcademyStages().getStageId() == ACADEMY_STAGE_PLANNED_ID
                    && academyStartDate.before(dateForComparison);
        });
        FITERS_FOR_REPORTS.put("in_process", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_IN_PROCESS_ID);
        FITERS_FOR_REPORTS.put("offering", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_OFFERING_ID);
        FITERS_FOR_REPORTS.put("graduated", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_GRADUATED_ID);
        FITERS_FOR_REPORTS.put("list_of_planned_releases", a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_BOARDING_ID);
    }

    @Override
    public ItaTacticalReport findById(int id) {
        return itaTacticalReportRepository.findOne(id);
    }

    @Override
    public Map<String, List<ItaTacticalReport>> generateItaTacticalReport() {
        Map<String, List<ItaTacticalReport>> itaTacticalReport = new HashMap<>();
        List<Academy> academies = academyService.getAllAcademies();
        for (String filterName : FITERS_FOR_REPORTS.keySet()) {
            List<Integer> ids = academies.stream()
                    .filter(FITERS_FOR_REPORTS.get(filterName))
                    .map(Academy::getAcademyId)
                    .collect(Collectors.toList());
            itaTacticalReport.put(filterName, itaTacticalReportRepository.findAllByAcademyIdIn(ids));
        }
        return itaTacticalReport;
    }


}
