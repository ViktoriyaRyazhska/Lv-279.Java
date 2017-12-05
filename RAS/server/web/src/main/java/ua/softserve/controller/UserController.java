package ua.softserve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.*;
import ua.softserve.service.UserService;
import ua.softserve.service.dto.CheckListByGroupsDto;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import static ua.softserve.util.dump.random.RandomUtil.ONE_MONTH_IN_MILES;


@RestController
public class UserController {
    @Autowired
    AcademyRepository academyRepository;
    @Autowired
    GroupInfoRepository groupInfoRepository;
    @Autowired
    GroupInfoTeachersRepository gitRepo;
    @Autowired
    LanguageTranslationsRepository ltRepo;
    @Autowired
    UserService uServ;
    @Autowired
    private ProfileRepository pRepo;
    @Autowired
    private EmployeeRepository eRepo;
    @Autowired
    private TeacherTypeRepository ttRepo;

    @GetMapping(value = "/group/randomAdd{count}", produces = {"application/json"})
    public ResponseEntity<String> randomGroups(@PathVariable int count) {
        List<Academy> academies = academyRepository.findAllByStartDateBetween(
                new Timestamp(System.currentTimeMillis() - 12 * ONE_MONTH_IN_MILES),
                new Timestamp(System.currentTimeMillis() + 12 * ONE_MONTH_IN_MILES)
        );
        Random r = new Random();
        List<Employee> employees = eRepo.findAll();
        for (Academy academy : academies) {
            GroupInfo gi = new GroupInfo();
            gi.setAcademy(academy);
            int sp = r.nextInt(3) + 5;
            gi.setStudentsPlannedToEnrollment(sp);
            gi.setStudentsPlannedToGraduate(sp - 1);

            Technologies tech = academy.getTechnologies();
            String techName = tech.getName();
            LanguageTranslations cityLT = ltRepo.findByItemId(academy.getCity().getCityId());
            String city = cityLT.getTrasnlation();
            gi.setGroupName(
                    city.substring(0, 2) +
                    (r.nextInt(700) + 300) +
                    "." + techName
            );

            List<ProfileInfo> pis = pRepo.findAllByTechnologiesTechnologyId(tech.getTechnologyId());
            gi.setProfileInfo(pis.get(r.nextInt(pis.size())));

            gi = groupInfoRepository.save(gi);

            int index = 0;
            int tc = (Math.random() < 0.85) ? 1 : 2;
            int ec = (Math.random() < 0.85) ? 1 : 2;
            int ic = (Math.random() < 0.85) ? 1 : 2;
            int emplC = tc + ec + ic;
            int ttIndex = 0;
            int[] indexes = getRandomEmployees(employees.size(), emplC);
            List<TeacherTypes> ttAll = ttRepo.findAll();
            for (int c = 0; c < emplC; c++) {
                if (c == tc) {
                    ttIndex++;
                }
                if (c == tc+ec) {
                    ttIndex++;
                }
                GroupInfoTeachers git = new GroupInfoTeachers();
                git.setAcademy(academy);
                git.setEmployee(employees.get(index++));
                git.setInvolved(100/tc);
                git.setContributedHours(r.nextInt(20)+10);
                git.setTeacherType(ttAll.get(ttIndex));
                gitRepo.save(git);
            }


        }

        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    private int[] getRandomEmployees(int size, int count) {
        int[] indexes = new int[count];
        if (size < count) {
            return null;
        }
        Random r = new Random();
        indexes[0] = r.nextInt(size);
        for (int i = 1; i < count; i++) {
            boolean flag = false;
            do {
                indexes[i] = r.nextInt(size);
                for (int j = 0; j < i; j++) {
                    if (indexes[i] == indexes[j]) {
                        flag = true;
                        break;
                    }
                }
            } while (flag);
        }

        return indexes;
    }


    /**
     * Demo controller for saving n random users
     *
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
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO employee" +
                "(employee_id, first_name_eng," +
                "last_name_eng, first_name_ukr," +
                "second_name_ukr, last_name_ukr)\n" +
                " VALUES\n");
        for (int i = 0; i < count; ) {
//            Employee employee = new Employee();
            RandomPerson randomPerson = RandomPersonGenerator.getRandomPerson();
            sb.append("(" +
                    ++i + ", " +
                    "'" + randomPerson.getFirstName() + "', " +
                    "'" + randomPerson.getLastName() + "', " +
                    "'" + randomPerson.getFirstNameUkr() + "', " +
                    "'" + randomPerson.getSecondNameUkr() + "', " +
                    "'" + randomPerson.getLastNameUkr() + "')");
            if (i < count) {
                sb.append(",\n");
            } else {
                sb.append(";\n");
            }
//            eRepo.save(employee);
        }
        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

    /**
     * Gets from DB list of all users.
     *
     * @return JSON object of list of all users from DB.
     */
    @GetMapping(value = "/user/getAllUsers", produces = {"application/json"})
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(uServ.findAll(), HttpStatus.OK);
    }
}
