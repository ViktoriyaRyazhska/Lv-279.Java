package ua.softserve.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.ItaTacticalReport;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.persistence.repo.ItaTacticalReportRepository;
import ua.softserve.service.AcademyService;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItaTacticalReportImplTest {

    @Mock
    ItaTacticalReportRepository itaTacticalReportRepository;
    @Mock
    AcademyRepository academyRepository;
    @Mock
    Map<String, Predicate<Academy>> FITERS_FOR_REPORTS;
    @InjectMocks
    ItaTacticalReportImpl itaTacticalReport = new ItaTacticalReportImpl();

    @Test
    public void generateItaTacticalReport() {
        itaTacticalReport.generateItaTacticalReport();

    }
}