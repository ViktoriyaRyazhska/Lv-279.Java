package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.config.ServiceConf;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.AcademyService;
import ua.softserve.service.UserService;

public class MainService {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceConf.class, DataConfig.class);

        AcademyService academyService = context.getBean(AcademyService.class);

            System.out.println(academyService.getById(1));


    }

}