package ua.softserve.service;

import ua.softserve.persistence.entity.LoginUser;

public interface LoginUserService {
    void save(LoginUser user);
    LoginUser findByUserName(String username);
}
