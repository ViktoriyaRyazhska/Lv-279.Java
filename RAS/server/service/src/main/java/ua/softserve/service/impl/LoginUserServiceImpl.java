package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.persistence.repo.LoginUserRepository;
import ua.softserve.service.LoginUserService;
import ua.softserve.service.SecurityContextService;

import java.util.Optional;

@Transactional
@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserRepository loginUserRepository;
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<LoginUser> user = loginUserRepository.findLoginUserByUsername(username);
        final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
        user.ifPresent(detailsChecker::check);
        return user.orElseThrow(() -> new UsernameNotFoundException("user not found."));
    }

    // @Override
    // public void save(LoginUser loginUser) {
    // loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));
    // loginUserRepository.save(loginUser);
    // }
}
