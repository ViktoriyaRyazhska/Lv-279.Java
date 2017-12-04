package ua.softserve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.User;
import ua.softserve.persistence.repo.EmployeeRepository;
import ua.softserve.service.UserService;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService uServ;

    @Autowired
    private EmployeeRepository eRepo;

    /**
     *
     * Demo controller for saving n random users
     * @param count (n) number of users to generating and saving
     * @return simple string 'Hello'
     */
    @GetMapping(value = "/user/randomAdd{count}", produces = {"application/json"})
    public ResponseEntity<String> randomAddUsers(@PathVariable int count) {
        uServ.genAndSaveUsers(count);
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping(value = "/empl/randomAdd{count}", produces = {"application/json"})
    public ResponseEntity<String> randomAddEmpl(@PathVariable int count) {
        for (int i = 0; i < count; i++) {
            Employee employee = new Employee();
            RandomPerson randomPerson = RandomPersonGenerator.getRandomPerson();
            employee.setFirstNameEng(randomPerson.getFirstName());
            employee.setLastNameEng(randomPerson.getLastName());
            eRepo.save(employee);
        }
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    /**
     * Gets from DB list of all users.
     * @return JSON object of list of all users from DB.
     */
    @GetMapping(value = "/user/getAllUsers", produces = {"application/json"})
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(uServ.findAll(), HttpStatus.OK);
    }
}
