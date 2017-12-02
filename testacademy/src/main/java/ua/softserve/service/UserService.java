/*
* UserService
*
* Version 1.0-SNAPSHOT
*
* 03.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service;

import ua.softserve.persistence.entity.User;

import java.util.List;

public interface UserService {
    void genAndSaveUsers(int countOfUsers);

    List<User> findAll();
}
