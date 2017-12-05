/*
* RandomGenerator
*
* Version 1.0-SNAPSHOT
*
* 02.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.dump.random;

import ua.softserve.util.dump.random.RandomPerson.Sex;

import java.util.Random;

import static ua.softserve.util.dump.random.RandomUtil.*;

/**
 * Util class for creating some <b>person</b>
 * with random data (sex, first name, second name, last name, email).
 */
public class RandomPersonGenerator {

    private static Random random = new Random();

    /**
     * Creates the person with random data.
     * @return created person.
     */
    public static RandomPerson getRandomPerson() {
        Sex sex = Sex.values()[random.nextInt(1)];
        RandomPerson person = new RandomPerson(sex);
        int r;

        if (sex == Sex.MALE) {

            r = random.nextInt(MAN_FIRST_NAMES.length);
            person.setFirstName(MAN_FIRST_NAMES[r]);
            person.setFirstNameUkr(MAN_FIRST_NAMES_UKR[r]);

            r = random.nextInt(MAN_SECOND_NAMES.length);
            person.setSecondName(MAN_SECOND_NAMES[r]);
            person.setSecondNameUkr(MAN_SECOND_NAMES_UKR[r]);

        } else {

            r = random.nextInt(WOMAN_FIRST_NAMES.length);
            person.setFirstName(WOMAN_FIRST_NAMES[r]);
            person.setFirstNameUkr(WOMAN_FIRST_NAMES_UKR[r]);

            r = random.nextInt(WOMAN_SECOND_NAMES.length);
            person.setSecondName(WOMAN_SECOND_NAMES[r]);
            person.setSecondNameUkr(WOMAN_SECOND_NAMES_UKR[r]);

        }

        r = random.nextInt(LAST_NAMES.length);
        person.setLastName(LAST_NAMES[r]);
        person.setLastNameUkr(LAST_NAMES_UKR[r]);

        person.setEmail(
                person.getFirstName().toLowerCase() +
                        "." +
                        person.getLastName().toLowerCase() +
                        getRandomEmailDomain()
        );
        return person;
    }

}