package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.ProfileInfo;
import ua.softserve.persistence.repo.ProfileRepository;
import ua.softserve.service.ProfileService;

import java.util.List;

@Service
public class ProfileInfoServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    @Override
    public void save(ProfileInfo profile) {
        profileRepository.save(profile);
    }

    @Override
    public ProfileInfo findOne(int id) {
        return profileRepository.findOne(id);
    }

    @Override
    public List<ProfileInfo> findAll() {
        return profileRepository.findAll();
    }

    @Transactional
    @Override
    public void remove(ProfileInfo profile) {
        profileRepository.delete(profile);
    }

    @Override
    public List<String> findProfileNames() {
        return profileRepository.findProfileNames();
    }
}
