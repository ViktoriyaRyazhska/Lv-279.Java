package ua.softserve.service;

import ua.softserve.data.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findUserById(int id);
}
