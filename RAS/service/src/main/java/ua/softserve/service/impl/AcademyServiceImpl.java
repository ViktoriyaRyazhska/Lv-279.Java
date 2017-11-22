package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.dto.AcademyDTO;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.AcademyService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    private AcademyDAO academyDAO;

    @Transactional(readOnly = true)
    @Override
    public Academy getById(Integer id) {
        return academyDAO.findOne(id);
    }

    @Transactional
    @Override
    public List<Academy> getAllAcademys() {
        return academyDAO.findAll();
    }

    @Transactional
    @Override
    public List<Academy> findAllByName(String name) {
        return academyDAO.findAllByName(name);
    }

    @Transactional
    @Override
    public void save(Academy academy) {
        academyDAO.save(academy);
    }

    @Transactional
    @Override
    public void saveDTO(AcademyDTO academyDTO) {
        Academy academy = new Academy();
        academy.setDirections(academyDTO.getDirection());
        academy.setTechnologies(academyDTO.getTechnologie());
        academy.setAcademy_stages(academyDTO.getAcademyStages());
        academy.setProfile(academyDTO.getProfile());
        academy.setName(academyDTO.getNameForSite());
        academy.setStartDate(convertStringToTimestamp(academyDTO.getStartDate()));
        academy.setEndDate(convertStringToTimestamp(academyDTO.getEndDate()));
        academy.setFree(academyDTO.getPayment());
        academy.setStatus(0);
        academy.setHasTech(0);
        academy.setHasEng(0);
        academy.setHasFirst(0);
        academy.setNotSynchronized(0);

            academyDAO.save(academy);
    }


    private Timestamp convertStringToTimestamp(String date){
        LocalDate localDate = LocalDate.parse(date);
        Timestamp timestamp = Timestamp.valueOf(localDate.atStartOfDay());
        return timestamp;
    }
}

