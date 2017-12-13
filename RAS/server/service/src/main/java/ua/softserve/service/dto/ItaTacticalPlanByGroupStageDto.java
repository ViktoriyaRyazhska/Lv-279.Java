package ua.softserve.service.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItaTacticalPlanByGroupStageDto {

    int groupId;
    private String groupName;
    private String CG;
    private String profile;
    private String location;
    private Date startDate;
    private Date endDate;
    private String groupStatus;
    private StringBuilder trainer;
    private int requested;
    private int studyInProgress;
    private int graduated;
    private int hired;
    private String comment;
    private String paymentSatus;
}
