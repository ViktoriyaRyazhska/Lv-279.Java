package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.ProfileRepository;
import ua.softserve.persistence.entity.Profile;
import ua.softserve.service.ProfileService;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Transactional
    @Override
    public Profile findOne(int id) {
        return profileRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Transactional
    @Override
    public void remove(Profile profile) {
        profileRepository.delete(profile);
    }

    @Override
    public List<String> findProfileNames() {
        return profileRepository.findProfileNames();
    }
}
