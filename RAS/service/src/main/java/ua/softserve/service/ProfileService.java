package ua.softserve.service;

import ua.softserve.persistence.entity.Profile;

import java.util.List;

public interface ProfileService {
    void save(Profile profile);

    Profile findOne(int id);

    List<Profile> findAll();

    void remove(Profile profile);

    List<String> findProfileNames();
}
