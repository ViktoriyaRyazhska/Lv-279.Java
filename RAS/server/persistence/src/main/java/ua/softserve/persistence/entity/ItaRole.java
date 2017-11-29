package ua.softserve.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ita_role")
public class ItaRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ita_role_id;

    @NotNull
    @Column(name = "role")
    private String role;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "itarole")
    private List<Employee> employees;

    @Override
    public String toString() {
        return "ItaRole{" +
                "ita_role_id=" + ita_role_id +
                ", role='" + role + '\'' +
                '}';
    }
}
