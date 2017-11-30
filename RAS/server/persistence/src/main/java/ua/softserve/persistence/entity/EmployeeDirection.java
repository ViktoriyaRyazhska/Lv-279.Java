package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "academy_direction_techers")
public class EmployeeDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn (name = "employee_id")
    private Employee employee;

    @Column(name = "load")
    private int load;

    @Column(name = "contributed_hours")
    private int contrHours;

    @Column(name = "group_id")
    private int groupId;

    @Column(name = "type_id")
    private int typeId;

    @ManyToOne
    @JoinColumn(name="type_id", insertable = false, updatable = false)
    private ItaRole itaRole;

    @Override
    public String toString() {
        return "EmployeeDirection{" +
                "id=" + id +
                '}';
    }


}
