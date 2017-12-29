package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ita_academy")
public class ItaAcademy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "it_academy_id")
    private Integer itAcademyId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @ManyToOne
    @JoinColumn(name = "it_academy_status_id")
    private ItaAcademyStatus itaAcademyStatus;
}
