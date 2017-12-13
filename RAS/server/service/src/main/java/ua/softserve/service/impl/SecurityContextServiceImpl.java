package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.persistence.repo.LoginUserRepository;
import ua.softserve.service.SecurityContextService;

import java.util.Optional;

@Service
@Transactional
public class SecurityContextServiceImpl implements SecurityContextService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    // @Autowired
    // public SecurityContextServiceImpl(UserRepository userRepository) {
    // this.userRepository = userRepository;
    // }

    @Override
    public Optional<LoginUser> currentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return loginUserRepository.findLoginUserByUsername(authentication.getName());
    }
}
