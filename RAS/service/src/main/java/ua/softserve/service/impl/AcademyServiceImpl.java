package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dto.AcademyDTO;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.City;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.service.AcademyService;
import ua.softserve.service.CityService;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.StudentGroupCountService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    private AcademyDAO academyDAO;

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



//        System.out.println(academy);

            academyDAO.save(academy);
    }


    private Timestamp convertStringToTimestamp(String date){
        LocalDate localDate = LocalDate.parse(date);
        Timestamp timestamp = Timestamp.valueOf(localDate.atStartOfDay());
        return timestamp;
    }

    private City getCity(String id){
        return cityService.findOne(Integer.parseInt(id));
    }



    @Transactional
    @Override
    public void saveCustom(int id, String role, int[] arr, EmployeeService employeeService) {
        List<Employee> employees;
        Academy academy;
        if (role.equals("Teacher")){
            academy=academyDAO.findWithEmployeeTeacher(id);
            employees=academy.getTeachers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))){
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setTeachers(employees);
            academyDAO.save(academy);
        }
        else if (role.equals("Expert")){
            academy=academyDAO.findWithEmployeeExperts(id);
            employees=academy.getExperts();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setExperts(employees);
            academyDAO.save(academy);
        }
        else if (role.equals("Interviewer")){
            academy=academyDAO.findWithEmployeeInterviewers(id);
            employees=academy.getInterviewers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setInterviewers(employees);
            academyDAO.save(academy);
        }
        else throw new IllegalArgumentException();
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
    public  List<Academy> findWithEmployeeExperts() {
        return academyDAO.findWithEmployeeExperts();
    }

}

