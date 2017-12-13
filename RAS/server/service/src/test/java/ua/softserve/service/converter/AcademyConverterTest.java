package ua.softserve.service.converter;

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
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.impl.GroupInfoServiceImpl;
import ua.softserve.service.impl.TechnologyServiceImpl;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class AcademyConverterTest {
    public static final int NUMBER_OF_INVOCATIONS = 8;
    @InjectMocks
    AcademyConverter academyConverter = new AcademyConverter();
    @Spy
    GroupInfo groupInfo;
    @Spy
    Academy academy;

    @Before
    public void setUp() {

    }

    @Test
    public void Group_Info_Returns_Null() {
        Mockito.when(groupInfo.getAcademy()).thenReturn(null);

        academyConverter.toDTO(groupInfo);

        Mockito.verify(groupInfo).getAcademy();
        Mockito.verify(groupInfo).getProfileInfo();
        Mockito.verify(groupInfo).getGroupName();
        Mockito.verify(groupInfo).getStudentsPlannedToEnrollment();
        Mockito.verify(groupInfo).getStudentsPlannedToGraduate();

        Mockito.verifyNoMoreInteractions(groupInfo);
    }

    @Test
    public void Group_Info_Returns_Not_Null() {
        Mockito.when(groupInfo.getAcademy()).thenReturn(academy);

        academyConverter.toDTO(groupInfo);

        Mockito.verify(groupInfo).getAcademy();

        Mockito.verify(groupInfo).getProfileInfo();
        Mockito.verify(groupInfo).getGroupName();
        Mockito.verify(groupInfo).getStudentsPlannedToEnrollment();
        Mockito.verify(groupInfo).getStudentsPlannedToGraduate();
    }
}
