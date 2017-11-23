package ua.softserve;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;

import ua.softserve.persistence.dao.LanguageTranslationsDAO;
import ua.softserve.persistence.dao.StudentRepository;
import ua.softserve.persistence.entity.Student;


import java.util.List;


public class MainPersistence {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);

        StudentRepository studentRepository = context.getBean(StudentRepository.class);


        List<Student> list = studentRepository.findStudentsByAcademyAndStatus(796,6);
        System.out.println(list.get(1).getTestFive());


//        UserDAO personService = context.getBean(UserDAO.class);
//
//        for (User user : personService.findAll()) {
//            System.out.println(user.getFirstName());
//        }
//        AcademyDAO academyDAO = context.getBean(AcademyDAO.class);
//        System.out.println(academyDAO.findOne(1));



//        HistoryDAO historyDAO = context.getBean(HistoryDAO.class);
//
//        for (History history:historyDAO.findAll() ) {
//            System.out.println(history.toString());
//
//        }
    }

}