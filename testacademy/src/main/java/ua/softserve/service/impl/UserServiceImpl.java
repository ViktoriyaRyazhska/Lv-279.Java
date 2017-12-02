/*
* UserServiceImpl
*
* Version 1.0-SNAPSHOT
*
* 03.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.User;
import ua.softserve.persistence.repo.UserRepository;
import ua.softserve.service.UserService;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository uRepo;

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
            uRepo.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        return uRepo.findAll();
    }


}
