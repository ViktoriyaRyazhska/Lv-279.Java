/*
* User
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service;

import ua.softserve.persistence.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findOne(int id);

    List<User> findAll();

    void remove(User user);

    /**
     * Demo method for saving n random users
     * @param countOfUsers (n) number of users to generating and saving
     */
    void genAndSaveUsers(int countOfUsers);

}
