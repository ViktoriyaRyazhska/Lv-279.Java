package ua.softserve.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyForViewDTO;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class GroupInfoServiceTest {
    private static final int EXPERT_STATUS_ID = 2;
    private static final int TRAINEE_STATUS_ID = 1;
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
    AcademyConverter academyConverter;
    @Mock
    AcademyStagesService academyStagesService;
    @Mock
    DirectionService directionService;
    @Mock
    TechnologyServiceImpl technologyServiceImpl;
    @Mock
    StudentService studentsService;
    @Mock
    ProfileService profileService;
    // @Mock
    // GroupInfoServiceImpl groupInfoService1;
    StudentStatuses studentStatuses;

    @Spy
    TeacherTypes teacherTypes;

    GroupInfo groupInfo;

    @InjectMocks
    GroupInfoServiceImpl groupInfoService = new GroupInfoServiceImpl();

    @Before
    public void setUp() {
        // teacherTypes = new TeacherTypes();
        groupInfo = new GroupInfo();
        groupInfo.setAcademy(new Academy());
        studentStatuses = new StudentStatuses();
    }

    @Test
    public void All_Services_Returns_Not_NULL() {
        Mockito.when(languageTranslationsService.getAllLanguageTranslationsName())
                .thenReturn(Arrays.asList(new LanguageTranslations(), new LanguageTranslations()));
        Mockito.when(teacherTypeService.findOne(EXPERT_STATUS_ID)).thenReturn(teacherTypes);
        Mockito.when(groupInfoService.findAllWithOrder()).thenReturn(Arrays.asList(groupInfo));
        Mockito.when(studentsStatusesService.findOne(TRAINEE_STATUS_ID)).thenReturn(studentStatuses);
        Mockito.when(academyConverter.toDTO(groupInfo)).thenReturn(new AcademyForViewDTO());

        groupInfoService.getInfoAboutStudents();

        Mockito.verify(languageTranslationsService).getAllLanguageTranslationsName();
        Mockito.verify(teacherTypeService).findOne(EXPERT_STATUS_ID);
        Mockito.verify(studentsStatusesService).findOne(TRAINEE_STATUS_ID);
        Mockito.verify(groupInfoTeachersService).findAllByTeacherType(teacherTypes);
        Mockito.verify(academyConverter).toDTO(groupInfo);
        Mockito.verify(studentsService).countAllByAcademyAndStudentStatus(groupInfo.getAcademy(), studentStatuses);

        Mockito.verifyNoMoreInteractions(languageTranslationsService, teacherTypeService, studentsStatusesService,
                groupInfoTeachersService, academyConverter, studentsService);
    }

    @Test
    public void Group_Info_List_Return_NULL() {
        Mockito.when(groupInfoService.findAllWithOrder()).thenReturn(null);
        Mockito.when(teacherTypeService.findOne(EXPERT_STATUS_ID)).thenReturn(teacherTypes);

        groupInfoService.getInfoAboutStudents();

        Mockito.verify(languageTranslationsService).getAllLanguageTranslationsName();
        Mockito.verify(teacherTypeService).findOne(EXPERT_STATUS_ID);
        Mockito.verify(studentsStatusesService).findOne(TRAINEE_STATUS_ID);
        Mockito.verify(groupInfoTeachersService).findAllByTeacherType(teacherTypes);

        Mockito.verifyNoMoreInteractions(languageTranslationsService, teacherTypeService, studentsStatusesService,
                groupInfoTeachersService, academyConverter, studentsService);
    }

    @Test
    public void Group_Info_Teacher_Service_Return_NULL() {
        Mockito.when(groupInfoService.findAllWithOrder()).thenReturn(Arrays.asList(groupInfo));
        Mockito.when(teacherTypeService.findOne(EXPERT_STATUS_ID)).thenReturn(teacherTypes);
        Mockito.when(groupInfoTeachersService.findAllByTeacherType(teacherTypes)).thenReturn(null);

        groupInfoService.getInfoAboutStudents();

        Mockito.verify(languageTranslationsService).getAllLanguageTranslationsName();
        Mockito.verify(academyConverter).toDTO(groupInfo);
        Mockito.verify(teacherTypeService).findOne(EXPERT_STATUS_ID);
        Mockito.verify(studentsStatusesService).findOne(TRAINEE_STATUS_ID);
        Mockito.verify(groupInfoTeachersService).findAllByTeacherType(teacherTypes);

        Mockito.verifyNoMoreInteractions(languageTranslationsService, teacherTypeService, studentsStatusesService,
                groupInfoTeachersService, academyConverter, studentsService);
    }
}