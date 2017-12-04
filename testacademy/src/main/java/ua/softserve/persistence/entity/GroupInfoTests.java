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

    @Column(name = "test_1_name")
    private String testOneName;

    @Column(name = "test_1_max_val")
    private String testOneMaxVal;

    @Column(name = "test_2_name")
    private String testTwoName;

    @Column(name = "test_2_max_val")
    private String testTwoMaxVal;

    @Column(name = "test_3_name")
    private String testThreeName;

    @Column(name = "test_3_max_val")
    private String testThreeMaxVal;

    @Column(name = "test_4_name")
    private String testFourName;

    @Column(name = "test_4_max_val")
    private String testFourMaxVal;

    @Column(name = "test_5_name")
    private String testFiveName;

    @Column(name = "test_5_max_val")
    private String testFiveMaxVal;

    @Column(name = "test_6_name")
    private String testSixName;

    @Column(name = "test_6_max_val")
    private String testSixMaxVal;

    @Column(name = "test_7_name")
    private String testSevenName;

    @Column(name = "test_7_max_val")
    private String testSevenMaxVal;

    @Column(name = "test_8_name")
    private String testEightName;

    @Column(name = "test_8_max_val")
    private String testEightMaxVal;

    @Column(name = "test_9_name")
    private String testNineName;

    @Column(name = "test_9_max_val")
    private String testNineMaxVal;

    @Column(name = "test_10_name")
    private String testTenName;

    @Column(name = "test_10_max_val")
    private String testTenMaxVal;

}
