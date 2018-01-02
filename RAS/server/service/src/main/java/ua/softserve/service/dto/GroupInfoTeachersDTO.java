package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GroupInfoTeachersDTO {
    private Integer id;
    private Integer academy;
    private Integer employee;
    private Integer involved;
    private Integer contributedHours;
    private String teacherType;
}
