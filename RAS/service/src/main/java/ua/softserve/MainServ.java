package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.persistence.dao.AcadeTestJpa;
import ua.softserve.service.AcademyService;

public class MainServ {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);

        AcademyService personService = context.getBean(AcademyService.class);

        System.out.println(personService.getById(796));
    }

}