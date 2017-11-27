package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.AcademyRepository;
import ua.softserve.persistence.dto.AcademyDTO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.City;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.EmployeeRoles;
import ua.softserve.service.AcademyService;
import ua.softserve.service.CityService;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.StudentGroupCountService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service
public class AcademyServiceImpl implements AcademyService {
    private static final int MAXROW = 10;
    @Autowired
    AcademyRepository academyRepository;

    @Autowired
    CityService cityService;

    @Autowired
    StudentGroupCountService studentGroupCountService;


    @Transactional(readOnly = true)
    @Override
    public Academy getById(Integer id) {
        return academyRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Academy> getAllAcademys() {
        return academyRepository.findAll();
    }

    @Transactional
    @Override
    public List<Academy> findAllByName(String name) {
        return academyRepository.findAllByName(name);
    }

    @Transactional
    @Override
    public void save(Academy academy) {
        academyRepository.save(academy);
    }

    @Transactional
    @Override
    public void saveDTO(AcademyDTO academyDTO) {
        Academy academy = new Academy();
        academy.setStudentGroupCount(studentGroupCountService.saveDTO(academyDTO));
        academy.setCity(getCity(academyDTO.getCityNames()));
        academy.setDirections(academyDTO.getDirection());
        academy.setTechnologies(academyDTO.getTechnologie());
        academy.setAcademyStages(academyDTO.getAcademyStages());
        academy.setProfile(academyDTO.getProfile());
        academy.setName(academyDTO.getNameForSite());
        academy.setStartDate(convertStringToTimestamp(academyDTO.getStartDate()));
        academy.setEndDate(convertStringToTimestamp(academyDTO.getEndDate()));
        academy.setFree(academyDTO.getPayment());

        academyRepository.save(academy);
    }


    private Timestamp convertStringToTimestamp(String date) {
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        } else if (date.isEmpty()) {
            throw new IllegalArgumentException("Date can't be empty");
        }

        LocalDate localDate = null;
        Timestamp timestamp = null;

        try {
            localDate = LocalDate.parse(date);
            timestamp = Timestamp.valueOf(localDate.atStartOfDay());
        } catch (ClassCastException e) {
            System.err.println(e);
        }
        return timestamp;
    }

    private City getCity(String id) {
        City city = cityService.findOne(Integer.parseInt(id));
        if (city == null) {
            //throw new ("Can't find city with id = " + id);
        }
        return city;
    }


    @Transactional
    @Override
    public void saveCustom(int id, String role, int[] arr, EmployeeService employeeService) {
        List<Employee> employees;
        Academy academy;
        if (role.equals(EmployeeRoles.Teacher.toString())) {
            academy = academyRepository.findWithEmployeeTeacher(id);
            employees = academy.getTeachers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setTeachers(employees);
            academyRepository.save(academy);
        } else if (role.equals(EmployeeRoles.Expert.toString())) {
            academy = academyRepository.findWithEmployeeExperts(id);
            employees = academy.getExperts();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setExperts(employees);
            academyRepository.save(academy);
        } else if (role.equals(EmployeeRoles.Interviewer.toString())) {
            academy = academyRepository.findWithEmployeeInterviewers(id);
            employees = academy.getInterviewers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setInterviewers(employees);
            academyRepository.save(academy);
        } else throw new IllegalArgumentException();
    }

    @Override
    public Academy findOne(int id) {
        return academyRepository.findOne(id);
    }

    @Override
    public Academy findWithEmployeeTeacher(int id) {
        return academyRepository.findWithEmployeeTeacher(id);
    }

    @Override
    public Academy findWithEmployeeExperts(int id) {
        return academyRepository.findWithEmployeeExperts(id);
    }

    @Override
    public Academy findWithEmployeeInterviewers(int id) {
        return academyRepository.findWithEmployeeInterviewers(id);
    }

    @Override
    public List<AcademyDTO> findWithEmployeeExperts() {
        List<Academy> academiesWithExperts = academyRepository.findWithEmployeeExperts();
        List<AcademyDTO> academyDTOS = new ArrayList<>();
        for (Academy academy : academiesWithExperts) {
            AcademyDTO academyDTO = new AcademyDTO();
            academyDTO.setNameForSite(academy.getName());
            academyDTO.setDirection(academy.getDirections());
            academyDTO.setAcademyStages(academy.getAcademyStages());
            academyDTO.setGrName(academy.getName());
            academyDTO.setStartDate(academy.getStartDate().toString());
            academyDTO.setEndDate(academy.getEndDate().toString());
            academyDTO.setProfile(academy.getProfile());
            academyDTO.setStudentsActual(0);
            academyDTO.setStudentsPlannedToGraduate(0);
            academyDTO.setStudentsPlannedToEnrollment(0);
            /*academyDTO.setStudentsActual(academy.getStudentGroupCount().getStudentsActual());
            academyDTO.setStudentsPlannedToGraduate(academy.getStudentGroupCount().getStudentsPlannedToGraduate());
            academyDTO.setStudentsPlannedToEnrollment(academy.getStudentGroupCount().getStudentsPlannedToEnrollment());*/
            academyDTO.setTechnologie(academy.getTechnologies());
            academyDTO.setCity(academy.getCity());
            academyDTO.setCityNames("ee");
            TreeMap<String, String> exp = new TreeMap<>();
            for (Employee experts : academy.getExperts()) {
                exp.put(experts.getFirstname(), experts.getLastname());
                academyDTO.setExpert(exp);
            }
            academyDTOS.add(academyDTO);
        }
        return academyDTOS;
    }
}

