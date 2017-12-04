package ua.softserve.service;

import ua.softserve.persistence.entity.ProfileInfo;

import java.util.List;

public interface ProfileService {
    void save(ProfileInfo profile);

    ProfileInfo findOne(int id);

    List<ProfileInfo> findAll();

    void remove(ProfileInfo profile);

    List<String> findProfileNames();
}
