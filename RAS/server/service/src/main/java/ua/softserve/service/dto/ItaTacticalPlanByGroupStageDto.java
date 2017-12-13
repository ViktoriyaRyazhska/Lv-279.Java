package ua.softserve.service.dto;

import lombok.*;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItaTacticalPlanByGroupStageDto {

    private  int year;
    private int month;
    private int groupId;
    private String groupName;
    private String CG;
    private String profile;
    private String location;
    private int requested;
    private int studyInProgress;
    private int graduated;
    private int hired;
    private Date startDate;
    private Date endDate;
    private String groupStatus;
    private StringBuilder trainer;
    private String comment;
    private String paymentSatus;
}
