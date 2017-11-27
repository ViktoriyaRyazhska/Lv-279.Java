package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dto.AcademyDTO;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.AcademyService;
import ua.softserve.service.CityService;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.StudentGroupCountService;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service
public class AcademyServiceImpl implements AcademyService {
    private static final int MAXROW = 10;
    @Autowired
    AcademyDAO academyDAO;

    @Autowired
    CityService cityService;

    @Autowired
    StudentGroupCountService studentGroupCountService;


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
        academy.setStatus(0);
        academy.setHasTech(0);
        academy.setHasEng(0);
        academy.setHasFirst(0);
        academy.setNotSynchronized(0);

        academyDAO.save(academy);
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
//        if (city == null) {
//            throw new NullPointerException("Can't find city with id = " + id);
//        }
        return city;
    }


    @Transactional
    @Override
    public void saveCustom(int id, String role, int[] arr, EmployeeService employeeService) {
        List<Employee> employees;
        Academy academy;
        if (role.equals("Teacher")) {
            academy = academyDAO.findWithEmployeeTeacher(id);
            employees = academy.getTeachers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setTeachers(employees);
            academyDAO.save(academy);
        } else if (role.equals("Expert")) {
            academy = academyDAO.findWithEmployeeExperts(id);
            employees = academy.getExperts();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setExperts(employees);
            academyDAO.save(academy);
        } else if (role.equals("Interviewer")) {
            academy = academyDAO.findWithEmployeeInterviewers(id);
            employees = academy.getInterviewers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setInterviewers(employees);
            academyDAO.save(academy);
        } else throw new IllegalArgumentException();
    }

    @Override
    public Academy findOne(int id) {
        return academyDAO.findOne(id);
    }

    @Override
    public Academy findWithEmployeeTeacher(int id) {
        return academyDAO.findWithEmployeeTeacher(id);
    }

    @Override
    public Academy findWithEmployeeExperts(int id) {
        return academyDAO.findWithEmployeeExperts(id);
    }

    @Override
    public Academy findWithEmployeeInterviewers(int id) {
        return academyDAO.findWithEmployeeInterviewers(id);
    }

    @Override
    public List<AcademyDTO> findWithEmployeeExperts() {
        List<Academy> academiesWithExperts = academyDAO.findWithEmployeeExperts();
        List<AcademyDTO> academyDTOS = new ArrayList<>();
        for(Academy academy: academiesWithExperts){
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
            for(Employee experts : academy.getExperts()){
                exp.put(experts.getFirstname(), experts.getLastname());
                academyDTO.setExpert(exp);
            }
            academyDTOS.add(academyDTO);

        }

        return academyDTOS;
    }
}

