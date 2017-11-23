package ua.softserve.persistence.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsViewDto {
    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer englishLevel;//users.eng_level
    private Double trainingScore;//rate
    private Double teacherScore;
    private Double expertScore;
    private Double current;
    private Double test1;
    private Double test2;
    private Double test3;
    private Double test4;
    private Double test5;
    private Double entryScore;
    private Double finalBase;//base
    private Double finalLang;//final test
    private Double test9;
    private Double test10;
    private Double englishGrammar; //language
    private Double interviewerScore;

}


