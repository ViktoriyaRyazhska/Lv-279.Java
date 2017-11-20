package ua.softserve.persistence.entity;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "crm_group")
    private int crmGroup;

    @Column(name = "academy_name")
    private String academyName;

    @Column(name = "name_for_site")
    private String nameForSite;

//    @Column(name = "location")
    private String location;

    @Column(name = "start_date")
    private Timestamp sartDate;

    @Column(name = "end_date")
    private Timestamp endDate;

   // @Column(name = "stage")
    private String stage;

   //@Column(name = "direction")
    private String direction;

    @Column(name = "modify_date")
    private Timestamp modifyDate;

    @Column(name = "modify_by")
    private String modifyBy;

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", academyName='" + academyName + '\'' +
                ", nameForSite='" + nameForSite + '\'' +
                ", location=" + location +
                ", sartDate=" + sartDate +
                ", endDate=" + endDate +
                ", stage=" + stage +
                ", direction=" + direction +
                ", modifyDate=" + modifyDate +
                ", modifyBy='" + modifyBy + '\'' +
                '}';
    }
}
