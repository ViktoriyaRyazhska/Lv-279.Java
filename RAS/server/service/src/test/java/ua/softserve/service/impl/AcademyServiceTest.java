//package ua.softserve.service.impl;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import ua.softserve.persistence.repo.AcademyRepository;
//import ua.softserve.persistence.entity.Academy;
//
//import java.util.Arrays;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
///**
// * Created by shevt on 23.11.2017.
// */
//public class AcademyServiceTest {
//    AcademyServiceImpl academyService;
//
//    AcademyRepository academyRepository;
//
//    @Before
//    public void setUp(){
//        academyService = new AcademyServiceImpl();
//
//        academyRepository = mock(AcademyRepository.class);
//        academyService.academyRepository = academyRepository;
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void findWithEmployeeExpertsTest(){
//        Mockito.when(academyRepository.findWithEmployeeExperts()).thenReturn(null);
//
//        academyService.findWithEmployeeExperts();
//
//        verify(academyRepository).findWithEmployeeExperts();
//    }
//
//    @Test
//    public void findWithEmployeeExpertsTest1(){
//        Mockito.when(academyRepository.findWithEmployeeExperts()).thenReturn(Arrays.asList(new Academy()));
//
//        academyService.findWithEmployeeExperts();
//
//        verify(academyRepository).findWithEmployeeExperts();
//    }
//}
