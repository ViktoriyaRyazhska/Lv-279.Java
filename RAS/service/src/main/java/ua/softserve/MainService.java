package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.config.ServiceConf;
import ua.softserve.persistence.dao.UserDAO;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.UserService;

public class MainService {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceConf.class, DataConfig.class);

        UserService personService = context.getBean(UserService.class);

        for (User user : personService.findAll()) {
            System.out.println(user.getFirstName());
        }

    }

}