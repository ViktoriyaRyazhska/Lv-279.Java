package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.persistence.entity.User;
import ua.softserve.persistence.repo.LoginUserRepository;
import ua.softserve.service.LoginUserService;
import ua.softserve.service.UserService;

import java.util.List;

@Transactional
@Service
public class LoginUserServiceImpl implements LoginUserService,UserDetailsService {
    @Autowired
    LoginUserRepository loginUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findByUserName(s);
    }

    public void save(LoginUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        loginUserRepository.save(user);
    }

    public LoginUser findByUserName(String username) {
        return loginUserRepository.findByUserName(username);
    }
}
