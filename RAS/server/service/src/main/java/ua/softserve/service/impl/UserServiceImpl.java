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
import ua.softserve.persistence.repo.UserRepository;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.UserService;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(int id) {
        return userRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        List<User> all = userRepository.findAll();
//        for (User user:all) {
//            System.out.println(user.getFirstName());
//        }
        return all;

    }

    @Override
    @Transactional
    public void remove(User User) {
        userRepository.delete(User);
    }

}
