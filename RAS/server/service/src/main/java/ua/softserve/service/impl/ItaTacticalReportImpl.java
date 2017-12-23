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

import static ua.softserve.persistence.constants.ConstantsFromDb.*;
import static ua.softserve.persistence.constants.ConstantsFromDb.ACADEMY_STAGE_BOARDING_ID;

@Service
public class ItaTacticalReportImpl implements ItaTacticalReportService {
    @Autowired
    private ItaTacticalReportRepository itaTacticalReportRepository;
    @Autowired
    private AcademyService academyService;

    private final Set<Predicate<Academy>> fitersFromReport;
    {
        fitersFromReport = new LinkedHashSet<>();
        fitersFromReport.add(a -> {
            Calendar dateForComparison = new GregorianCalendar();
            dateForComparison.add(Calendar.MONTH, 2);
            Calendar academyStartDate = new GregorianCalendar();
            academyStartDate.setTimeInMillis(a.getStartDate().getTime());
            return a.getAcademyStages().getStageId() == ACADEMY_STAGE_PLANNED_ID
                    && academyStartDate.before(dateForComparison);
        });
        fitersFromReport.add(a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_IN_PROCESS_ID);
        fitersFromReport.add(a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_OFFERING_ID);
        fitersFromReport.add(a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_GRADUATED_ID);
        fitersFromReport.add(a -> a.getAcademyStages().getStageId() == ACADEMY_STAGE_BOARDING_ID);
    }


    @Override
    public ItaTacticalReport findById(int id) {

        return itaTacticalReportRepository.findOne(id);
    }

    @Override
    public List<List<ItaTacticalReport>> generateItaTacticalReport() {
        List<List<ItaTacticalReport>> itaTacticalReport = new ArrayList<>();
        List<Academy> academies = academyService.getAllAcademies();
        for (Predicate<Academy> filter : fitersFromReport) {
            ArrayList<ItaTacticalReport> someReport = new ArrayList<>();
            academies.stream()
                    .filter(filter)
                    .forEach(a -> someReport.add(this.findById(a.getAcademyId())));
            itaTacticalReport.add(someReport);
        }
        return itaTacticalReport;
    }
}
