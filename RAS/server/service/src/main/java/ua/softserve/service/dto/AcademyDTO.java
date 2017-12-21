package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.softserve.persistence.entity.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class AcademyDTO extends AcademyDropDownLists{
    private String grName;
    private String nameForSite;
    private int academyStagesId;
    private Long startDate;
    private Long endDate;
    private int payment;
    private int studentPlannedToGraduate;
    private int studentPlannedToEnrollment;
    private int studentsActual;

}
