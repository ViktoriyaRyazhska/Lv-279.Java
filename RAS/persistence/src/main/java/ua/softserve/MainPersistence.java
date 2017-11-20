package ua.softserve;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.dao.HistoryDAO;
import ua.softserve.persistence.dao.UserDAO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.History;
import ua.softserve.persistence.entity.User;

public class MainPersistence {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);

//        UserDAO personService = context.getBean(UserDAO.class);
//
//        for (User user : personService.findAll()) {
//            System.out.println(user.getFirstName());
//        }


//        HistoryDAO historyDAO = context.getBean(HistoryDAO.class);
//
//        for (History history:historyDAO.findAll() ) {
//            System.out.println(history.toString());
//
//        }

        AcademyDAO historyDAO = context.getBean(AcademyDAO.class);
        System.out.println(historyDAO.findOne(1));

    }

}