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
        person.setLastName(RandomUtil.getRandomLastName());
        person.setEmail(
                person.getFirstName().toLowerCase() +
                        "." +
                        person.getLastName().toLowerCase() +
                        RandomUtil.getRandomEmailDomain()
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
                ? RandomUtil.getRandomManFirstName()
                : RandomUtil.getRandomWomanFirstName();
    }

    /**
     * Generate random second name.
     * @param male second names are divided by sex,
     *             and you can chose which type of names must be generated.
     * @return generated second name.
     */
    public static String genSecondName(Sex male) {
        return (male == Sex.MALE)
                ? RandomUtil.getRandomManSecondName()
                : RandomUtil.getRandomWomanSecondName();
    }

}