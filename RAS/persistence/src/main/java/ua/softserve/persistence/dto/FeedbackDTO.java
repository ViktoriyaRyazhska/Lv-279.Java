package ua.softserve.persistence.dto;


import lombok.*;
import ua.softserve.persistence.entity.Mark;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeedbackDTO {
    private Mark learningAbility;
    private Mark overallTechnicalCompetence;
    private Mark passionalInitiative;
    private Mark teamWork;
    private Mark gettingThingsDone;
    private Mark activeCommunicator;
    private String summary;
    private int proficient;
}



