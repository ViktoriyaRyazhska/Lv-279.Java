/*
* GroupInfoTests
*
* Version 1.0-SNAPSHOT
*
* 04.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

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
@Table(name = "group_info_tests")
public class GroupInfoTests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;


}
