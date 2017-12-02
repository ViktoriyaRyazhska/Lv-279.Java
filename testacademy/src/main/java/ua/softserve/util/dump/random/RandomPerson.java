/*
* RandomPerson
*
* Version 1.0-SNAPSHOT
*
* 03.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.dump.random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class of Persons.
 * Consists of <b>sex, first name, second name, last name and email</b>.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RandomPerson {
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private Sex sex;

    public RandomPerson(Sex s) {
        sex = s;
    }

    /**
     * Enum of sex types.
     */
    public enum Sex {
        MALE, FEMALE;
    }
}