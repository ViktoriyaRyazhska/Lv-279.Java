package ua.softserve.validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.exception.InvalidDataException;
import ua.softserve.service.exception.InvalidTimeFrameException;
import ua.softserve.validator.impl.GroupValidatorImpl;

import static org.junit.Assert.*;

public class GroupValidatorTest {
    GroupValidatorImpl groupValidator;
    AcademyDTO academyDTO;

    @Before
    public void setUp() throws Exception {
        groupValidator = new GroupValidatorImpl();

        academyDTO = new AcademyDTO();
        academyDTO.setNameForSite("test");
        academyDTO.setGrName("test");
        academyDTO.setStartDate(1500000L);
        academyDTO.setEndDate(1600000L);
        academyDTO.setStudentPlannedToGraduate(14);
        academyDTO.setStudentPlannedToEnrollment(88);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ifNameIsNull() throws Exception {
        academyDTO.setGrName(null);
        try {
            groupValidator.validate(academyDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Group Name"));
        }
    }

    @Test
    public void ifNameIsEmpty() throws Exception {
        academyDTO.setGrName("");
        try {
            groupValidator.validate(academyDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Group Name"));
        }
    }

    @Test
    public void ifNameForSiteIsNull() throws Exception {
        academyDTO.setNameForSite(null);
        try {
            groupValidator.validate(academyDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Name for Site"));
        }
    }

    @Test
    public void ifNameForSiteIsEmpty() throws Exception {
        academyDTO.setNameForSite("");
        try {
            groupValidator.validate(academyDTO);
            fail();
        } catch (InvalidDataException e) {
            assertTrue(e.getMessage().contains("Name for Site"));
        }
    }

    @Test(expected = InvalidDataException.class)
    public void ifGroupNameLennghtMoreThan50Char() throws Exception {
        academyDTO.setGrName("1234567891234567891234567891234567891234567891234567");
        groupValidator.validate(academyDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifNameForSiteLennghtMoreThan50Char() throws Exception {
        academyDTO.setNameForSite("1234567891234567891234567891234567891234567891234567");
        groupValidator.validate(academyDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToGraduateMoreThan99() throws Exception {
        academyDTO.setStudentPlannedToGraduate(101);
        groupValidator.validate(academyDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToGraduateLessThan0() throws Exception {
        academyDTO.setStudentPlannedToGraduate(-2);
        groupValidator.validate(academyDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToEnrollmentMoreThan99() throws Exception {
        academyDTO.setStudentPlannedToEnrollment(101);
        groupValidator.validate(academyDTO);
    }

    @Test(expected = InvalidDataException.class)
    public void ifStudentPlannedToEnrollmentLessThan0() throws Exception {
        academyDTO.setStudentPlannedToEnrollment(-2);
        groupValidator.validate(academyDTO);
    }

    @Test(expected = InvalidTimeFrameException.class)
    public void startDateLessThanEndDate() throws Exception {
        academyDTO.setStartDate(160000000L);
          academyDTO.setEndDate(150000000L);
        groupValidator.validate(academyDTO);
    }
}