package ua.softserve.validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.service.exception.InvalidDataException;
import ua.softserve.service.exception.InvalidTimeFrameException;
import ua.softserve.validator.impl.GroupValidatorImpl;

import static org.junit.Assert.*;

public class GroupValidatorTest {
    GroupValidatorImpl groupValidator;
    AcademyForSaveDTO academyForSaveDTO;

    @Before
    public void setUp() throws Exception {
        groupValidator = new GroupValidatorImpl();

        academyForSaveDTO = new AcademyForSaveDTO();
        academyForSaveDTO.setNameForSite("test");
        academyForSaveDTO.setGrName("test");
        academyForSaveDTO.setStartDate(1500000L);
        academyForSaveDTO.setEndDate(1600000L);
        academyForSaveDTO.setStudentPlannedToGraduate(14);
        academyForSaveDTO.setStudentPlannedToEnrollment(88);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ifNameIsNull() throws Exception {
        academyForSaveDTO.setGrName(null);
        try {
            groupValidator.validate(academyForSaveDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Group Name"));
        }
    }

    @Test
    public void ifNameIsEmpty() throws Exception {
        academyForSaveDTO.setGrName("");
        try {
            groupValidator.validate(academyForSaveDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Group Name"));
        }
    }

    @Test
    public void ifNameForSiteIsNull() throws Exception {
        academyForSaveDTO.setNameForSite(null);
        try {
            groupValidator.validate(academyForSaveDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Name for Site"));
        }
    }

    @Test
    public void ifNameForSiteIsEmpty() throws Exception {
        academyForSaveDTO.setNameForSite("");
        try {
            groupValidator.validate(academyForSaveDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Name for Site"));
        }
    }

    @Test(expected = InvalidDataException.class)
    public void ifGroupNameLennghtMoreThan50Char() throws Exception {
        academyForSaveDTO.setGrName("1234567891234567891234567891234567891234567891234567");
        groupValidator.validate(academyForSaveDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifNameForSiteLennghtMoreThan50Char() throws Exception {
        academyForSaveDTO.setNameForSite("1234567891234567891234567891234567891234567891234567");
        groupValidator.validate(academyForSaveDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToGraduateMoreThan99() throws Exception {
        academyForSaveDTO.setStudentPlannedToGraduate(101);
        groupValidator.validate(academyForSaveDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToGraduateLessThan0() throws Exception {
        academyForSaveDTO.setStudentPlannedToGraduate(-2);
        groupValidator.validate(academyForSaveDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToEnrollmentMoreThan99() throws Exception {
        academyForSaveDTO.setStudentPlannedToEnrollment(101);
        groupValidator.validate(academyForSaveDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToEnrollmentLessThan0() throws Exception {
        academyForSaveDTO.setStudentPlannedToEnrollment(-2);
        groupValidator.validate(academyForSaveDTO);
    }

    @Test(expected = InvalidTimeFrameException.class)
    public void startDateLessThanEndDate() throws Exception {
        academyForSaveDTO.setStartDate(160000000L);
          academyForSaveDTO.setEndDate(150000000L);
        groupValidator.validate(academyForSaveDTO);
    }
}