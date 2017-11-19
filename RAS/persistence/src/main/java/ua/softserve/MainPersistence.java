package ua.softserve;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ua.softserve.config.DataConfig;
import ua.softserve.persistence.dao.UserDAO;
import ua.softserve.persistence.entity.User;

public class MainPersistence {

    public static void main(String[] args) {




        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);

        UserDAO personService = context.getBean(UserDAO.class);
/*
        for (User user : personService.findAll()) {
            System.out.println(user.getFirstName());
        }
*/

    }

}