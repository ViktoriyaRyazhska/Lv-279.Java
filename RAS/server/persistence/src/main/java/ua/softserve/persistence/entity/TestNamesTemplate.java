package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "teste_name_template")
public class TestNamesTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long testTemplateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "templateDirectionId", referencedColumnName = "technology_id")
    private Technologies technologies;

    @Column(name = "test_name")
    private String testName;

    @NotNull
    @Column(name = "test_max_score")
    private Double testMaxScore;
}
