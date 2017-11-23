package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ssu_student_feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "learning_ability")
    private Mark learningAbility;

    @ManyToOne
    @JoinColumn(name = "technical_competence")
    private Mark overallTechnicalCompetence;

    @ManyToOne
    @JoinColumn(name = "passional_initiative")
    private Mark passionalInitiative;

    @ManyToOne
    @JoinColumn(name = "team_work")
    private Mark teamWork;

    @ManyToOne
    @JoinColumn(name = "getting_things_done")
    private Mark gettingThingsDone;

    @ManyToOne
    @JoinColumn(name = "active_communicator")
    private Mark activeCommunicator;

    @Column(name = "summary_comment")
    private String summary;

    @Override
    public String toString() {
        return "Feedback{" +
                "learningAbility=" + learningAbility +
                ", overallTechnicalCompetence=" + overallTechnicalCompetence +
                ", passionalInitiative=" + passionalInitiative +
                ", teamWork=" + teamWork +
                ", gettingThingsDone=" + gettingThingsDone +
                ", activeCommunicator=" + activeCommunicator +
                ", summary='" + summary + '\'' +
                '}';
    }
}
