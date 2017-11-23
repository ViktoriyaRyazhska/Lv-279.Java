package ua.softserve.repository.dao;

import ua.softserve.data.entity.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    List<User> findAll();
    User findUserById(int id);
}
