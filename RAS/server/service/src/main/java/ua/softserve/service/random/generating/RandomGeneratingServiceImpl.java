/*
 * RandomGenerationServiceImpl
 *
 * Version 1.0-SNAPSHOT
 *
 * 06.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.service.random.generating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.*;
import ua.softserve.service.UserService;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static ua.softserve.util.dump.random.RandomUtil.ONE_MONTH_IN_MILES;
import static ua.softserve.util.dump.random.RandomUtil.getRandomDouble;

/**
 * Service for generating random data for database
 */
@Service
public class RandomGeneratingServiceImpl implements RandomGenerating {
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
    private StudentRepository sRepo;
    @Autowired
    private StudentsStatusesRepository ssRepo;
    @Autowired
    private EnglishLevelRepository elRepo;
    @Autowired
    private MarkRepository mRepo;

    /**
     * Generates random groups with all information
     *
     * and saves them in the database
     */
    public void randomGroups() {
        List<Academy> academies = academyRepository.findAllByStartDateBetween(
                new Timestamp(System.currentTimeMillis() - 12 * ONE_MONTH_IN_MILES),
                new Timestamp(System.currentTimeMillis() + 12 * ONE_MONTH_IN_MILES));
        // List<Academy> academies = academyRepository.findAll()
        // .stream().filter(academy -> academy.getAcademyId()==1).collect(Collectors.toList());
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
            String city = cityLT.stream().filter(lt -> lt.getLocal() == 'e').collect(Collectors.toList()).get(0)
                    .getTrasnlation();
            gi.setGroupName(city.substring(0, 2) + "-" + (r.nextInt(700) + 300) + "." + techName);

            List<ProfileInfo> pis = pRepo.findAllByTechnologiesTechnologyId(tech.getTechnologyId());
            if (pis == null || pis.size() == 0) {
                gi.setProfileInfo(null);
            } else {
                gi.setProfileInfo(pis.get(r.nextInt(pis.size())));
            }

            groupInfoRepository.save(gi);

            int tc = (Math.random() < 0.85) ? 1 : 2;
            int ec = (Math.random() < 0.85) ? 1 : 2;
            int ic = (Math.random() < 0.85) ? 1 : 2;
            int emplC = tc + ec + ic;
            int ttIndex = 0;
            Set<Employee> employees = getRandomEmployees(emplC, employeesAll);
            if (employees == null) {
                return;
            }
            List<TeacherTypes> ttAll = ttRepo.findAll();
            int c = 0;
            for (Employee employee : employees) {
                if (c == tc) {
                    ttIndex++;
                }
                if (c == tc + ec) {
                    ttIndex++;
                }
                GroupInfoTeachers git = new GroupInfoTeachers();
                git.setAcademy(academy);
                git.setEmployee(employee);
                git.setInvolved(100 / tc);
                git.setContributedHours(r.nextInt(20) + 10);
                git.setTeacherType(ttAll.get(ttIndex));
                gitRepo.save(git);
                c++;
            }

            StudentStatuses ss = ssRepo.findOne(1);
            Employee approvedBy = employeesAll.get(r.nextInt(employees.size()));
            Set<User> users = getRandomUsers(sp, usersAll);
            if (users == null) {
                return;
            }
            List<EnglishLevel> engLevs = elRepo.findAll();
            for (User user : users) {

                Student student = new Student();
                student.setAcademy(academy);
                student.setApprovedBy(approvedBy);
                student.setUser(user);
                student.setStudentStatus(ss);
                StudentTestData data = new StudentTestData();
                data.setEnglishLevel(engLevs.get(r.nextInt(engLevs.size())));
                data.setEngGram(getRandomDouble(3, 11));
                data.setEntryScore(getRandomDouble(300, 1001));

                data.setIncomingTest(r.nextInt(7001) + 300);
                data.setIntermBase(getRandomDouble(3, 11));
                data.setIntermLang(getRandomDouble(300, 1001));
                data.setFinalBase(getRandomDouble(30, 101));
                data.setFinalLang(getRandomDouble(300, 1001));

                data.setTestOne(getRandomDouble(30, 101));
                data.setTestTwo(getRandomDouble(3, 11));
                data.setTestThree(getRandomDouble(300, 1001));
                data.setTestFour(getRandomDouble(30, 101));
                data.setTestFive(getRandomDouble(300, 1001));
                data.setTestSix(getRandomDouble(300, 1001));
                data.setTestSeven(getRandomDouble(300, 1001));
                data.setTestEight(getRandomDouble(30, 101));
                data.setTestNine(getRandomDouble(300, 1001));
                data.setTestTen(getRandomDouble(3, 11));

                student.setTeacherFeedback(getRandomFeedback());
                data.setTeacherScore(getRandomDouble(3, 6));
                student.setExpertFeedback(getRandomFeedback());
                data.setExpertScore(getRandomDouble(3, 6));
                data.setInterviewerScore(getRandomDouble(3, 6));

                data.setInterviewerComment("Bla bla bla");
                student.setData(data);

                sRepo.save(student);
            }

        }
    }

    /**
     * Demo method for saving n random users
     *
     * @param count
     *            (n) number of users to generating and saving
     * @return simple string 'Hello'
     */
    public void randomAddUsers(int count) {
        genAndSaveUsers(count);
    }

    /**
     * Demo method for saving n random users
     * 
     * @param countOfUsers
     *            (n) number of users to generating and saving
     */
    public void genAndSaveUsers(int countOfUsers) {
        for (int i = 0; i < countOfUsers; i++) {
            User user = new User();
            RandomPerson person = RandomPersonGenerator.getRandomPerson();
            user.setFirstName(person.getFirstName());
            user.setLastName(person.getLastName());
            user.setEmail(person.getEmail());
            user.setUserName(person.getFirstName().toLowerCase() + person.getLastName().toLowerCase());
            user.setPhone("+38(000)000-00-00");
            uServ.save(user);
        }
    }

    /**
     * Generates random employees
     *
     * @param count
     *            of random employees
     *
     * @return script for inserting employees to database
     */
    public String randomAddEmpl(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO employee" + "(employee_id, first_name_eng," + "last_name_eng, first_name_ukr,"
                + "second_name_ukr, last_name_ukr)\n" + " VALUES\n");
        for (int i = 0; i < count;) {
            RandomPerson randomPerson = RandomPersonGenerator.getRandomPerson();
            sb.append("(" + ++i + ", " + "'" + randomPerson.getFirstName() + "', " + "'" + randomPerson.getLastName()
                    + "', " + "'" + randomPerson.getFirstNameUkr() + "', " + "'" + randomPerson.getSecondNameUkr()
                    + "', " + "'" + randomPerson.getLastNameUkr() + "')");
            if (i < count) {
                sb.append(",\n");
            } else {
                sb.append(";\n");
            }
            // Employee employee = new Employee();
            // employee.setFirstNameEng(randomPerson.getFirstName());
            // employee.setLastNameEng(randomPerson.getLastName());
            // employee.setFirstNameUkr(randomPerson.getFirstNameUkr());
            // employee.setSecondNameUkr(randomPerson.getSecondNameUkr());
            // employee.setLastNameUkr(randomPerson.getLastNameUkr());
            // eRepo.save(employee);
        }
        return sb.toString();
    }

    /**
     * Returns random set of employees from entry list
     *
     * @param count
     *            of employees
     *
     * @param allEmpl
     *            entry list of employees
     *
     * @return random set of employees
     */
    private Set<Employee> getRandomEmployees(int count, List<Employee> allEmpl) {
        Set<Employee> employees = new HashSet<>();
        Random random = new Random();
        while (employees.size() < count) {
            employees.add(allEmpl.get(random.nextInt(allEmpl.size())));
        }
        return employees;
    }

    /**
     * Returns random set of users from entry list
     *
     * @param count
     *            of users
     *
     * @param allUsers
     *            entry list of users
     *
     * @return random set of users
     */
    private Set<User> getRandomUsers(int count, List<User> allUsers) {
        Set<User> employees = new HashSet<>();
        Random random = new Random();
        while (employees.size() < count) {
            employees.add(allUsers.get(random.nextInt(allUsers.size())));
        }
        return employees;
    }

    /**
     * Generates random feedback
     *
     * @return random feedback
     */
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
}
