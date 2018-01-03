package ua.softserve.service.impl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.GroupInfoConverter;
import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.service.exception.InvalidDataException;
import ua.softserve.service.exception.InvalidTimeFrameException;
import ua.softserve.validator.impl.GroupValidatorImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AcademyServiceImplTest {
    @Mock
    AcademyRepository academyRepository;

    @Mock
    AcademyStagesService academyStagesService;

    @Mock
    DirectionService directionService;

    @Mock
    TechnologyServiceImpl technologyServiceImpl;

    @Mock
    ProfileService profileService;

    @Mock
    LanguageTranslationsService languageTranslationsService;

    @Mock
    GroupInfoService groupInfoService;

    @Spy
    List<Academy> listAcademys;

    @Mock
    AcademyForSaveDTO academyForSaveDTO;

    @Mock
    Academy academy;

    @Spy
    GroupInfo groupInfo;

    @Mock
    GroupInfoConverter groupInfoConverter;

    @Mock
    GroupValidatorImpl groupValidator;

    @InjectMocks
    AcademyServiceImpl academyServiceImpl;

    @Before
    public void setUp() {
        academyForSaveDTO = new AcademyForSaveDTO();
        academyForSaveDTO.setGrName("Group Name");
        academyForSaveDTO.setNameForSite("Name For Site");
        academyForSaveDTO.setStartDate(15000000L);
        academyForSaveDTO.setEndDate(16000000L);
    }

    @Test
    public void getDropdownListFromAcademyDto() throws Exception {
        academyServiceImpl.getAcademyDTO();
        verify(academyStagesService).getAllAcademyStagesService();
        verify(directionService).findAllDirectionsInIta();
        verify(technologyServiceImpl).findAllTechonologyInIta();
        verify(profileService).findAll();
        verify(languageTranslationsService).getAllLanguageTranslationsName();
    }

    @Test(expected = NoSuchElementException.class)
    public void findOneNull() throws Exception {
        when(academyRepository.findOne(anyInt())).thenReturn(null);
        academyServiceImpl.findOne(anyInt());
    }

    @Test
    public void findOne() throws Exception {
        when(academyRepository.findOne(anyInt())).thenReturn(academy);
        academyServiceImpl.findOne(1);
        verify(academyRepository).findOne(anyInt());
    }

    @Test
    public void save() throws Exception {
        when(academyRepository.save(academy)).thenReturn(academy);
        academyServiceImpl.save(academy);
        verify(academyRepository).save(academy);
    }

    @Ignore
    @Test
    public void saveAcademyAndGroupInfoFromAcademyDTO() throws Exception {
        doNothing().when(groupValidator).validate(academyForSaveDTO);
        when(groupInfoConverter.academyToEntity(academyForSaveDTO)).thenReturn(academy);
        when(academyRepository.save(academy)).thenReturn(academy);
        when(groupInfoConverter.groupInfoToEntity(academy.getAcademyId(), academyForSaveDTO)).thenReturn(groupInfo);
        doNothing().when(groupInfoService).save(groupInfo);
        academyServiceImpl.saveAcademyAndGroupInfoFromAcademyDTO(academyForSaveDTO);
        verify(groupValidator).validate(academyForSaveDTO);
        verify(groupInfoConverter).academyToEntity(academyForSaveDTO);
        verify(academyRepository).save(academy);
        verify(groupInfoConverter).groupInfoToEntity(academy.getAcademyId(), academyForSaveDTO);
        verify(groupInfoService).save(groupInfo);
        verifyNoMoreInteractions(groupValidator, groupInfoConverter, academyRepository, groupInfoConverter, groupInfoService);

    }

    @Test
    public void getAllAcademies() throws Exception {
        when(academyRepository.findAll()).thenReturn(listAcademys);
        academyServiceImpl.getAllAcademies();
        verify(academyRepository).findAll();
    }
}