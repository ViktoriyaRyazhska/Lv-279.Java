package ua.softserve.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "crm_group")
    private Integer crmGroup;

    @Column(name = "academy_name")
    private String academyName;

    @Column(name = "name_for_site")
    private String nameForSite;

    private String location;

    @Column(name = "start_date")
    private Timestamp sartDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    private String stage;

    private String direction;

    @Column(name = "modify_date")
    private Timestamp modifyDate;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "academy_id")
    private int academyId;

}
