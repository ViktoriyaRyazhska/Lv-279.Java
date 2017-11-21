package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.config.ServiceConf;
import ua.softserve.persistence.entity.History;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.AcademyService;
import ua.softserve.service.HistoryService;
import ua.softserve.service.UserService;

public class MainService {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceConf.class, DataConfig.class);

//        AcademyService academyService = context.getBean(AcademyService.class);
//
//            System.out.println(academyService.getById(1));

//        HistoryService historyService = context.getBean(HistoryService.class);
//
//        for (History history:historyService.findByCrmGroup(428)) {
//            System.out.println(history.toString());
//
//        }

        UserService userService = context.getBean(UserService.class);
        for (User user: userService.findAll()) {
            System.out.println(user.getFirstName());

        }

    }

}