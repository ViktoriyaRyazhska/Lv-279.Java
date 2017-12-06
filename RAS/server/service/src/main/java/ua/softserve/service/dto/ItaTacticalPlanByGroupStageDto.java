package ua.softserve.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItaTacticalPlanByGroupStageDto {

    int groupId;
    private String groupName;
    private String CG;
    private String Profile;
    private String Location;
    private Date startDate;
    private Date endDate;
    private String groupStatus;
    private String paymentSatus;
    private String comment;
    private List trainer;
    private int requested;
    private int studyInProgress;
    private int graduated;
    private int hired;

}
