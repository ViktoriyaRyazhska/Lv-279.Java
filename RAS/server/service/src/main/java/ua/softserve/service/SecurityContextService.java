package ua.softserve.service;

import ua.softserve.persistence.entity.LoginUser;

import java.util.Optional;

public interface SecurityContextService {

    Optional<LoginUser> currentUser();

}
