package ua.softserve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.*;
import ua.softserve.service.UserService;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static ua.softserve.util.dump.random.RandomUtil.ONE_MONTH_IN_MILES;
import static ua.softserve.util.dump.random.RandomUtil.getRandomDouble;


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
    @Autowired
    private StudentsRepository sRepo;
    @Autowired
    private StudentsStatusesRepository ssRepo;
    @Autowired
    private EnglishLevelRepository elRepo;
    @Autowired
    private MarkRepository mRepo;

    @GetMapping(value = "/group/randomAdd", produces = {"application/json"})
    public ResponseEntity<String> randomGroups() {
        List<Academy> academies = academyRepository.findAllByStartDateBetween(
                new Timestamp(System.currentTimeMillis() - 12 * ONE_MONTH_IN_MILES),
                new Timestamp(System.currentTimeMillis() + 12 * ONE_MONTH_IN_MILES)
        );
//        List<Academy> academies = academyRepository.findAll()
//                .stream().filter(academy -> academy.getAcademyId()==1).collect(Collectors.toList());
        Random r = new Random();
        List<Employee> employeesAll = eRepo.findAll();
        List<User> usersAll = uServ.findAll();
        for (Academy academy : academies) {
            GroupInfo gi = new GroupInfo();
            gi.setAcademy(academy);

            int sp = r.nextInt(3) + 5;
            gi.setStudentsPlannedToEnrollment(sp);
            gi.setStudentsPlannedToGraduate(sp - 1);

            Technologies tech = academy.getTechnologies();
            String techName = tech.getName();
            List<LanguageTranslations> cityLT = ltRepo.findAllByItemId(academy.getCity().getCityId());
            String city = cityLT
                    .stream()
                    .filter(lt -> lt.getLocal()=='e')
                    .collect(Collectors.toList())
                    .get(0)
                    .getTrasnlation();
            gi.setGroupName(
                    city.substring(0, 2) + "-" +
                    (r.nextInt(700) + 300) +
                    "." + techName
            );

            List<ProfileInfo> pis = pRepo.findAllByTechnologiesTechnologyId(tech.getTechnologyId());
            if (pis == null || pis.size() == 0) {
                gi.setProfileInfo(null);
            } else {
                gi.setProfileInfo(pis.get(r.nextInt(pis.size())));
            }

            groupInfoRepository.save(gi);

//            int index = 0;
            int tc = (Math.random() < 0.85) ? 1 : 2;
            int ec = (Math.random() < 0.85) ? 1 : 2;
            int ic = (Math.random() < 0.85) ? 1 : 2;
            int emplC = tc + ec + ic;
            int ttIndex = 0;
//            int[] indexes = getRandomIndexes(employees.size(), emplC);
//            if (indexes == null) {
//                return null;
//            }
            Set<Employee> employees = getRandomEmployees(emplC, employeesAll);
            if (employees == null) {
                return null;
            }
            List<TeacherTypes> ttAll = ttRepo.findAll();
            int c = 0;
            for (Employee employee : employees) {
                if (c == tc) {
                    ttIndex++;
                }
                if (c == tc+ec) {
                    ttIndex++;
                }
                GroupInfoTeachers git = new GroupInfoTeachers();
                git.setAcademy(academy);
                git.setEmployee(employee);
                git.setInvolved(100/tc);
                git.setContributedHours(r.nextInt(20)+10);
                git.setTeacherType(ttAll.get(ttIndex));
                gitRepo.save(git);
                c++;
            }


            StudentStatuses ss = ssRepo.findOne(1);
            Employee approvedBy = employeesAll.get(r.nextInt(employees.size()));
//            index = 0;
//            indexes = getRandomIndexes(users.size(), sp);
//            if (indexes == null) {
//                return null;
//            }
            Set<User> users = getRandomUsers(sp, usersAll);
            if (users == null) {
                return null;
            }
            List<EnglishLevel> engLevs = elRepo.findAll();
            for (User user: users) {

                Students student = new Students();
                student.setAcademy(academy);
                student.setApprovedBy(approvedBy);
                student.setUser(user);
                student.setStudentStatus(ss);
                student.setEnglishLevel(engLevs.get(r.nextInt(engLevs.size())));
                student.setEngGram(getRandomDouble(3,11));
                student.setEntryScore(getRandomDouble(300,1001));

                student.setIncomingTest(r.nextInt(7001)+300);
                student.setIntermBase(getRandomDouble(3,11));
                student.setIntermLang(getRandomDouble(300,1001));
                student.setFinalBase(getRandomDouble(30,101));
                student.setFinalLang(getRandomDouble(300,1001));

                student.setTestOne(getRandomDouble(30,101));
                student.setTestTwo(getRandomDouble(3,11));
                student.setTestThree(getRandomDouble(300,1001));
                student.setTestFour(getRandomDouble(30,101));
                student.setTestFive(getRandomDouble(300,1001));
                student.setTestSix(getRandomDouble(300,1001));
                student.setTestSeven(getRandomDouble(300,1001));
                student.setTestEight(getRandomDouble(30,101));
                student.setTestNine(getRandomDouble(300,1001));
                student.setTestTen(getRandomDouble(3,11));

                student.setTeacherFeedback(getRandomFeedback());
                student.setTeacherScore(getRandomDouble(3,6));
                student.setExpertFeedback(getRandomFeedback());
                student.setExpertScore(getRandomDouble(3,6));
                student.setInterviewerScore(getRandomDouble(3,6));

                student.setInterviewerComment("Bla bla bla");

                sRepo.save(student);
            }


        }

        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    private Set<Employee> getRandomEmployees(int count, List<Employee> allEmpl) {
        Set<Employee> employees = new HashSet<>();
        Random random = new Random();
        while (employees.size() < count) {
            employees.add(allEmpl.get(random.nextInt(allEmpl.size())));
        }
        return employees;
    }

    private Set<User> getRandomUsers(int count, List<User> allUrsers) {
        Set<User> employees = new HashSet<>();
        Random random = new Random();
        while (employees.size() < count) {
            employees.add(allUrsers.get(random.nextInt(allUrsers.size())));
        }
        return employees;
    }

    private Feedback getRandomFeedback() {
        Random r = new Random();
        Feedback feedback = new Feedback();
        List<Mark> marks = mRepo.findAllByCharacteristicId(1);
        feedback.setLearningAbility(marks.get(r.nextInt(marks.size())));
        marks = mRepo.findAllByCharacteristicId(2);
        feedback.setOverallTechnicalCompetence(marks.get(r.nextInt(marks.size())));
        marks = mRepo.findAllByCharacteristicId(3);
        feedback.setPassionalInitiative(marks.get(r.nextInt(marks.size())));
        marks = mRepo.findAllByCharacteristicId(4);
        feedback.setTeamWork(marks.get(r.nextInt(marks.size())));
        marks = mRepo.findAllByCharacteristicId(5);
        feedback.setGettingThingsDone(marks.get(r.nextInt(marks.size())));
        marks = mRepo.findAllByCharacteristicId(6);
        feedback.setActiveCommunicator(marks.get(r.nextInt(marks.size())));
        feedback.setSummary("Bla bla bla");
        return feedback;
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
//            Employee employee = new Employee();
//            employee.setFirstNameEng(randomPerson.getFirstName());
//            employee.setLastNameEng(randomPerson.getLastName());
//            employee.setFirstNameUkr(randomPerson.getFirstNameUkr());
//            employee.setSecondNameUkr(randomPerson.getSecondNameUkr());
//            employee.setLastNameUkr(randomPerson.getLastNameUkr());
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
