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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.softserve.util.dump.random.RandomPerson.Sex;

import java.util.Random;

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
        RandomPerson person = new RandomPerson(Sex.values()[random.nextInt(1)]);
        person.setFirstName(genFirstName(person.getSex()));
        person.setSecondName(genSecondName(person.getSex()));
        person.setLastName(genLastName());
        person.setEmail(
                person.getFirstName().toLowerCase() +
                "." +
                person.getLastName().toLowerCase() +
                Constants.EMAIL_DOMAINS[random.nextInt(Constants.EMAIL_DOMAINS.length)]
        );
        return person;
    }

    /**
     * Generate random first name.
     * @param male first names are divided by sex,
     *             and you can chose which type of names must be generated.
     * @return generated first name.
     */
    public static String genFirstName(Sex male) {
        return (male == Sex.MALE)
                ? Constants.MAN_FIRST_NAMES[random.nextInt(Constants.MAN_FIRST_NAMES.length)]
                : Constants.WOMAN_FIRST_NAMES[random.nextInt(Constants.MAN_FIRST_NAMES.length)];
    }

    /**
     * Generate random second name.
     * @param male second names are divided by sex,
     *             and you can chose which type of names must be generated.
     * @return generated second name.
     */
    public static String genSecondName(Sex male) {
        return (male == Sex.MALE)
                ? Constants.MAN_SECOND_NAMES[random.nextInt(Constants.MAN_SECOND_NAMES.length)]
                : Constants.WOMAN_SECOND_NAMES[random.nextInt(Constants.MAN_SECOND_NAMES.length)];
    }

    /**
     * Generate random last name.
     * @return generated last name.
     */
    public static String genLastName() {
        return Constants.LAST_NAMES[random.nextInt(Constants.LAST_NAMES.length)];
    }

}
