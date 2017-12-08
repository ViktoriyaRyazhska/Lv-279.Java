package ua.softserve.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ua.softserve.persistence.entity.LanguageTranslations;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.*;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class GroupInfoServiceTest {
    @Mock
    LanguageTranslationsService languageTranslationsService;
    @Mock
    TeacherTypeService teacherTypeService;
    @Mock
    StudentsStatusesService studentsStatusesService;
    @Mock
    GroupInfoTeachersService groupInfoTeachersService;
    @Mock
    StudentService studentService;
    @Mock
    GroupInfoRepository groupInfoRepository;
    @Mock
    AcademyStagesService academyStagesService;
    @Mock
    DirectionService directionService;
    @Mock
    TechnologyServiceImpl technologyServiceImpl;
    @Mock
    ProfileService profileService;

    @InjectMocks
    GroupInfoServiceImpl groupInfoService = new GroupInfoServiceImpl();

    @Test
    public void test1(){
        Mockito.when(languageTranslationsService.getAllLanguageTranslationsName()).thenReturn(Arrays.asList(new LanguageTranslations(), new LanguageTranslations()));

        groupInfoService.getAllAcademies();

        Mockito.verify(languageTranslationsService).getAllLanguageTranslationsName();
    }
}