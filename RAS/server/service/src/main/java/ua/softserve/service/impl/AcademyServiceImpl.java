package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;

import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    AcademyRepository academyRepository;

    @Autowired
    AcademyStagesService academyStagesService;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologyServiceImpl technologyServiceImpl;

    @Autowired
    ProfileService profileService;

    @Autowired
    LanguageTranslationsService languageTranslationsService;

    @Autowired
    GroupInfoService groupInfoService;

    @Autowired
    private AcademyConverter academyConverter;

    @Transactional(readOnly = true)
    @Override
    public Academy getById(Integer id) {
        return academyRepository.findOne(id);
    }

    @Transactional
    @Override
    public Integer save(Academy academy) {
        return academyRepository.save(academy).getAcademyId();
    }

    @Transactional
    @Override
    public void saveAcademyFromAcademyDTO(AcademyDTO academyDTO) {
        Academy academy = academyConverter.toEntity(academyDTO);

        int academyId = save(academy);

        saveGroupInfo(academyId, academyDTO);
    }

    private void saveGroupInfo(int academyId, AcademyDTO academyDTO) {
        GroupInfo groupInfo = academyConverter.groupInfoToEntity(academyId, academyDTO);
        groupInfoService.save(groupInfo);
    }

    @Transactional
    @Override
    public Academy findOne(int id) {
        return academyRepository.findOne(id);
    }

    @Transactional
    @Override
    public AcademyDTO getAcademyDTO() {
        AcademyDTO academyDTO = new AcademyDTO();
        academyDTO.setAcademyStages(academyStagesService.getAllAcademyStagesService());
        academyDTO.setDirection(directionService.findAllDirectionsInIta());
        academyDTO.setTechnologie(technologyServiceImpl.findAllTechonologyInIta());
        academyDTO.setProfile(profileService.findAll());
        academyDTO.setCityNames(languageTranslationsService.getAllLanguageTranslationsName());
        return academyDTO;
    }

    @Transactional
    @Override
    public List<Academy> getAllAcademies() {
        return academyRepository.findAll();
    }

    // @Transactional
    // @Override
    // public void saveCustom(int id, String role, int[] arr, EmployeeService employeeService) {
    // List<Employee> employees;
    // Academy academy;
    // if (role.equals("Teacher")) {
    // academy = academyRepository.findWithEmployeeTeacher(id);
    // employees = academy.getTeachers();
    // for (int i : arr) {
    // if (!employees.contains(employeeService.findOne(i))) {
    // employees.add(employeeService.findOne(i));
    // }
    // }
    // academy.setTeachers(employees);
    // academyRepository.save(academy);
    // for(Employee empl : employees) {
    // employeeDirectionService.addEmployeeToGroup(id, empl,1);
    // }
    // } else if (role.equals("Expert")) {
    // academy = academyRepository.findWithEmployeeExperts(id);
    // employees = academy.getExperts();
    // for (int i : arr) {
    // if (!employees.contains(employeeService.findOne(i))) {
    // employees.add(employeeService.findOne(i));
    // }
    // }
    // academy.setExperts(employees);
    // academyRepository.save(academy);
    // for(Employee empl : employees) {
    // employeeDirectionService.addEmployeeToGroup(id, empl,2);
    // }
    // } else if (role.equals("Interviewer")) {
    // academy = academyRepository.findWithEmployeeInterviewers(id);
    // employees = academy.getInterviewers();
    // for (int i : arr) {
    // if (!employees.contains(employeeService.findOne(i))) {
    // employees.add(employeeService.findOne(i));
    // }
    // }
    // academy.setInterviewers(employees);
    // academyRepository.save(academy);
    // for(Employee empl : employees) {
    // employeeDirectionService.addEmployeeToGroup(id, empl,3);
    // }
    // } else throw new IllegalArgumentException();
    // }
}
