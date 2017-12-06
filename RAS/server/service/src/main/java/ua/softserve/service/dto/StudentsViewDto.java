package ua.softserve.service.dto;

import lombok.*;
import ua.softserve.persistence.entity.Feedback;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsViewDto {
    private Integer studentId;
    private String fullName;
    private Integer englishLevel;
    private Double trainingScore;
    private Double teacherScore;
    private Double expertScore;
    private Double current;
    private Double test1;
    private Double test2;
    private Double test3;
    private Double test4;
    private Double test5;
    private Double entryScore;
    private Double finalBase;
    private Double finalLang;
    private Double test9;
    private Double test10;
    private Double englishGrammar;
    private Double interviewerScore;
    private Feedback teacherFeedback = new Feedback();
    private Feedback expertFeedback = new Feedback();
}
