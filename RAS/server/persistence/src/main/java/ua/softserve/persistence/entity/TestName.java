package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "testes_names")
public class TestName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long testId;

    @NotNull
    @Column(name = "test_name")
    private String testName;

    @NotNull
    @Column(name = "test_max_score")
    private Double testMaxScore;

//    @ManyToMany(mappedBy = "testNames", cascade = CascadeType.PERSIST)
//    private List<Student> students;

    public TestName(){}

    public TestName(String testName,double testMaxScore) {
        this.testName = testName;
        this.testMaxScore = testMaxScore;
    }

    @Override
    public String toString() {
        return "TestName{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", testMaxScore=" + testMaxScore +
                '}';
    }
}
