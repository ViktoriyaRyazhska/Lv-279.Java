package ua.softserve.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.AcademyService;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by shevt on 23.11.2017.
 */
public class AcademyServiceTest {
    AcademyServiceImpl academyService;

    AcademyDAO academyDAO;

    @Before
    public void setUp(){
        academyService = new AcademyServiceImpl();

        academyDAO = mock(AcademyDAO.class);
        academyService.academyDAO = academyDAO;
    }

    @Test(expected = RuntimeException.class)
    public void findWithEmployeeExpertsTest(){
        Mockito.when(academyDAO.findWithEmployeeExperts()).thenReturn(null);

        academyService.findWithEmployeeExperts();

        verify(academyDAO).findWithEmployeeExperts();
    }

    @Test
    public void findWithEmployeeExpertsTest1(){
        Mockito.when(academyDAO.findWithEmployeeExperts()).thenReturn(Arrays.asList(new Academy()));

        academyService.findWithEmployeeExperts();

        verify(academyDAO).findWithEmployeeExperts();
    }
}
