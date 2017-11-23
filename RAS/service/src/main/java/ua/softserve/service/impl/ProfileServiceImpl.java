package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.ProfileDAO;
import ua.softserve.persistence.entity.Profile;
import ua.softserve.service.ProfileService;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDAO profileDAO;

    @Transactional
    @Override
    public void save(Profile profile) {
        profileDAO.save(profile);
    }

    @Transactional
    @Override
    public Profile findOne(int id) {
        return profileDAO.findOne(id);
    }

    @Transactional
    @Override
    public List<Profile> findAll() {
        return profileDAO.findAll();
    }

    @Transactional
    @Override
    public void remove(Profile profile) {
        profileDAO.delete(profile);
    }

    @Override
    public List<String> findProfileNames() {
        return profileDAO.findProfileNames();
    }
}
