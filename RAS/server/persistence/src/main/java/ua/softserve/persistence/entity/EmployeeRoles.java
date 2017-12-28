package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class EmployeeRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeroles_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "employeeRoles")
    private Set<LoginUser> loginUsers;
}
