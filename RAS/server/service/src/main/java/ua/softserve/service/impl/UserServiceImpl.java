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
import ua.softserve.persistence.repo.UserDAO;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.UserService;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

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
        List<User> all = userDAO.findAll();
        for (User user:all) {
            System.out.println(user.getFirstName());
        }
        return all;

    }

    @Override
    @Transactional
    public void remove(User User) {
        userDAO.delete(User);
    }

    /**
     * Demo method for saving n random users
     * @param countOfUsers (n) number of users to generating and saving
     */
    @Override
    public void genAndSaveUsers(int countOfUsers) {
        for (int i = 0; i < countOfUsers; i++) {
            User user = new User();
            RandomPerson person = RandomPersonGenerator.getRandomPerson();
            user.setFirstName(person.getFirstName());
            user.setLastName(person.getLastName());
            user.setEmail(person.getEmail());
            user.setUserName(person.getFirstName().toLowerCase() +
                    person.getLastName().toLowerCase());
            user.setPhone("+38(000)000-00-00");
            userDAO.save(user);
        }
    }

}
