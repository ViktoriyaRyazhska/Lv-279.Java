/*
 * RandomGeneration
 *
 * Version 1.0-SNAPSHOT
 *
 * 06.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.service.random.generating;

public interface RandomGenerating {

    /**
     * Generates random groups with all information
     *
     * and saves them in the database
     */
    public void randomGroups();

    /**
     * Demo method for saving n random users
     *
     * @param count
     *            (n) number of users to generating and saving
     * @return simple string 'Hello'
     */
    public void randomAddUsers(int count);

    /**
     * Demo method for saving n random users
     * 
     * @param count
     *            (n) number of users to generating and saving
     */
    public void genAndSaveUsers(int count);

    /**
     * Generates random employees
     *
     * @param count
     *            of random employees
     *
     * @return script for inserting employees to database
     */
    public String randomAddEmpl(int count);

}
