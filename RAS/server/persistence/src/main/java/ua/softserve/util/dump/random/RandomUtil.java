/*
* Constants
*
* Version 1.0-SNAPSHOT
*
* 02.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.dump.random;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Class with constants of person data (firs, second, last names, email domains, etc.)
 */
public class RandomUtil {

    /**
     * Number of milliseconds in one month. <b>This value is inaccurate because of different number of days in the
     * month</b>
     */
    public static final long ONE_MONTH_IN_MILES = 2592000000l;
    public final static String[] MAN_FIRST_NAMES = {"Volodymyr", "Orest", "Ivan", "Stepan", "Roman", "Vasyl", "Oleh",
            "Ihor", "Andriy", "Nazar", "Rostyslav", "Ostap", "Tymofiy", "Petro", "Pavlo", "Bohdan", "Taras", "Markiyan",
            "Maryan", "Grygoriy", "Serhiy"};
    public final static String[] WOMAN_FIRST_NAMES = {"Olga", "Olena", "Ivanka", "Sofiya", "Vasylyna", "Khrystyna",
            "Iryna", "Larysa", "Karina", "Romana", "Anna", "Natalya", "Anastasiya", "Polina", "Margaryta", "Mariya",
            "Marta", "Paraska", "Antonina", "Darya", "Daryna", "Solomiya", "Tetyana"};
    public final static String[] MAN_SECOND_NAMES = {"Volodymyrovych", "Orestovych", "Ivanovych", "Stepanovych",
            "Romanovych", "Vasylovych", "Olehovych", "Ihorovych", "Andriyovych", "Nazarovych", "Rostyslavovych",
            "Ostapovych", "Tymofiyovych", "Petrovych", "Pavlovych", "Bohdanovych", "Tarasovych", "Markiyanovych",
            "Maryanovych", "Grygoriyovych", "Serhiyovych"};
    public final static String[] WOMAN_SECOND_NAMES = {"Volodymyrivna", "Orestivna", "Ivanivna", "Stepanivna",
            "Romanivna", "Vasylivna", "Olehivna", "Ihorivna", "Andriyivna", "Nazarivna", "Rostyslavivna", "Ostapivna",
            "Tymofiyivna", "Petrivna", "Pavlivna", "Bohdanivna", "Tarasivna", "Markiyanivna", "Maryanivna",
            "Grygoriyivna", "Serhiyivna"};
    public final static String[] LAST_NAMES = {"Mykytyn", "Melnyk", "Pikula", "Shymchak", "Moskal", "Bandera",
            "Poroshenko", "Putin", "Kuchma", "Moroz", "Kuybida", "Gnyp", "Barna", "Figurka", "Semygen", "Ivashchuk",
            "Shkilnyk", "Kostyuk", "Barylyak", "Koziy", "Zakharchuk"};
    public final static String[] MAN_FIRST_NAMES_UKR = {"Володимир", "Орест", "Іван", "Степан", "Роман", "Василь",
            "Олег", "Ігор", "Андрій", "Назар", "Ростислав", "Остап", "Тимофій", "Петро", "Павло", "Богдан", "Тарас",
            "Маркіян", "Мар`ян", "Григорій", "Сергій"};
    public final static String[] WOMAN_FIRST_NAMES_UKR = {"Ольга", "Олена", "Іванка", "Софія", "Василина", "Христина",
            "Ірина", "Лариса", "Каріна", "Романа", "Анна", "Наталія", "Анастасія", "Поліна", "Маргарита", "Марія",
            "Марта", "Параска", "Антоніна", "Дарья", "Дарина", "Соломія", "Тетяна"};
    public final static String[] MAN_SECOND_NAMES_UKR = {"Володимирович", "Орестович", "Іванович", "Степанович",
            "Романович", "Васильович", "Олегович", "Ігорович", "Андрійович", "Назарович", "Ростиславович", "Остапович",
            "Тимофійович", "Петрович", "Павлович", "Богданович", "Тарасович", "Маркіянович", "Мар`янович",
            "Григорійович", "Сергійович"};
    public final static String[] WOMAN_SECOND_NAMES_UKR = {"Володимирівна", "Орестівна", "Іванівна", "Степанівна",
            "Романівна", "Васильівна", "Олегівна", "Ігорівна", "Андрійівна", "Назарівна", "Ростиславівна", "Остапівна",
            "Тимофійівна", "Петрівна", "Павлівна", "Богданівна", "Тарасівна", "Маркіянівна", "Мар`янівна",
            "Григорійівна", "Сергійівна"};
    public final static String[] LAST_NAMES_UKR = {"Микитин", "Мельник", "Пікула", "Шимчак", "Москаль", "Бандера",
            "Порошенко", "Путін", "Кучма", "Мороз", "Куйбіда", "Гнип", "Барна", "Фігурка", "Семиген", "Івашчук",
            "Шкільник", "Костюк", "Бариляк", "Козій", "Захарчук"};
    private static final int STUDENTS_MAX_COUNT = 9;
    private static final int STUDENTS_MIN_COUNT = 5;
    private final static String[] GROUP_NAMES_SUFIX = {"Java", "DotNet", "QC", "ISTQB", "Angulyar", "FrontEnd", "Dev",
            "JS", "NodeJS", "Ruby"};
    private final static String[] GROUP_STATUSES = {"In Process", "Offering", "Graduated"};
    private final static String[] STUDENT_STATUSES = {"Trainee", "Accepted pre-offer", "Graduated", "Rejected"};
    private final static int START_INDEX_CORRECT_ENGLISH_LEVEL = 7;
    private final static String[] ENGLISH_LEVELS = {"Beginner low", "Beginner", "Beginner high", "Elementary low",
            "Elementary", "Elementary high", "Pre-Intermediate low", "Pre-Intermediate", "Pre-Intermediate high",
            "Intermediate low", "Intermediate", "Intermediate high", "Upper intermediate low", "Upper intermediate",
            "Upper intermediate high", "Advanced low", "Advanced", "Advanced high", "Proficient low", "Proficient",
            "Proficient high"};
    private final static String[][] FEEDBACKS = {{"QUICK", "NORMAL", "HARD TO LEARN", "CAN'T EVALUATE"},
            {"STRONG", "GOOD", "NON-TECHNICAL", "CAN'T EVALUATE"},
            {"INITITATIVE", "EQUAL TO MAJORITY", "CAN'T EVALUATE"},
            {"TEAM PLAYER", "WORKS ALONE", "LEADER", "CAN'T EVALUATE"},
            {"STRONG AREA", "NEEDS IMPROVEMENT", "CAN'T EVALUATE"},
            {"LISTENER AND PRESENTER", "LISTENER", "WEAK COMMUNICATION", "CAN'T EVALUATE"}};
    private final static String[] EMAIL_DOMAINS = {"@gmail.com", "@i.ua", "@yahoo.com", "@softserve.ua",
            "@softserveinc.com", "@ukr.net", "@gov.ua"};
    private final static String[] CITIES = {"Lviv", "Kyiv", "Frankivsk", "Chernivci", "Rivne", "Kharkiv", "Vinnytsya",
            "Odesa"};
    private static Random random = new Random();

    /**
     * Returns random last name.
     *
     * @return random last name.
     */
    public static String getRandomLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    /**
     * Returns random man first name.
     *
     * @return random man first name.
     */
    public static String getRandomManFirstName() {
        return MAN_FIRST_NAMES[random.nextInt(MAN_FIRST_NAMES.length)];
    }

    /**
     * Returns random woman first name.
     *
     * @return random woman first name.
     */
    public static String getRandomWomanFirstName() {
        return WOMAN_FIRST_NAMES[random.nextInt(WOMAN_FIRST_NAMES.length)];
    }

    /**
     * Returns random man second name.
     *
     * @return random man second name.
     */
    public static String getRandomManSecondName() {
        return MAN_SECOND_NAMES[random.nextInt(MAN_SECOND_NAMES.length)];
    }

    /**
     * Returns random woman second name.
     *
     * @return random woman second name.
     */
    public static String getRandomWomanSecondName() {
        return WOMAN_SECOND_NAMES[random.nextInt(WOMAN_SECOND_NAMES.length)];
    }

    /**
     * Returns random email domain.
     *
     * @return random email domain.
     */
    public static String getRandomEmailDomain() {
        return EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)];
    }

    /**
     * Returns random city.
     *
     * @return random city.
     */
    public static String getRandomCity() {
        return CITIES[random.nextInt(CITIES.length)];
    }

    /**
     * Returns random date between from and to
     *
     * @param from start date
     * @param to   end date
     * @return random date between from and to
     */
    public static Date getRandomDateBetween(Date from, Date to) {
        long start = from.getTime();
        long end = to.getTime();
        return new Date(((long) (Math.random() * (end - start))) + start);
    }

    /**
     * Returns random group name by city.
     *
     * @return random group name by city.
     */
    public static String getRandomGroupNameByCity(String city) {
        return city.substring(0, 2) + (random.nextInt(900) + 100) + "."
                + GROUP_NAMES_SUFIX[random.nextInt(GROUP_NAMES_SUFIX.length)];
    }

    /**
     * Returns random status of group.
     *
     * @return random status of group.
     */
    public static String getRandomGroupStatus() {
        return GROUP_STATUSES[random.nextInt(GROUP_STATUSES.length)];
    }

    /**
     * Returns random students count.
     *
     * @return random students count.
     */
    public static int getRandomStudentsCount() {
        return random.nextInt(STUDENTS_MAX_COUNT - STUDENTS_MIN_COUNT) + STUDENTS_MIN_COUNT;
    }

    /**
     * Returns random english level.
     *
     * @return random english level.
     */
    public static String getRandomEnglishLevel() {
        return ENGLISH_LEVELS[random.nextInt(ENGLISH_LEVELS.length)];
    }

    /**
     * Returns random correct english level.
     *
     * @return random correct english level.
     */
    public static String getRandomCorrectEnglishLevel() {
        return ENGLISH_LEVELS[random.nextInt(ENGLISH_LEVELS.length - START_INDEX_CORRECT_ENGLISH_LEVEL)
                + START_INDEX_CORRECT_ENGLISH_LEVEL];
    }

    /**
     * Returns random double value between min and max.
     *
     * @param min min value.
     * @param max max value
     * @return random double value between min and max.
     */
    public static double getRandomDouble(double min, double max) {
        return (double) (Math.round((Math.random() * (max - min) + min) * 100)) / 100;
    }

    /**
     * Returns random student status.
     *
     * @return random student status.
     */
    public static String getRandomStudentStatus() {
        return STUDENT_STATUSES[random.nextInt(STUDENT_STATUSES.length)];
    }

    /**
     * Returns random list of feedbacks.
     *
     * @return random list of feedbacks.
     */
    public static List<String> getRandomFeedbacks() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < FEEDBACKS.length; i++) {
            list.add(FEEDBACKS[i][random.nextInt(FEEDBACKS[i].length)]);
        }
        return list;
    }

}