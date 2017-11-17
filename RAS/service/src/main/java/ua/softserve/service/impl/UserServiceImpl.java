/*
* UserServiceImpl
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.UserDAO;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(int id) {
        return userDAO.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDAO.findAll();

    }

    @Override
    @Transactional
    public void remove(User User) {
        userDAO.delete(User);
    }

}
