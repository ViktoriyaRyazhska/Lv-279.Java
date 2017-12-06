package ua.softserve.service;

import ua.softserve.persistence.entity.Profile;

import java.util.List;

public interface ProfileService {
    void save(Profile user);

    Profile findOne(int id);

    List<Profile> findAll();

    void remove(Profile user);

    List<String> findProfileNames();
}
