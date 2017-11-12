package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.AppConfig;
import ua.softserve.data.entity.Academy;
import ua.softserve.repository.dao.AcademyDAO;
import ua.softserve.repository.dao.impl.AcademyDAOImpl;
import ua.softserve.service.AcademyService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AcademyService personService = context.getBean(AcademyService.class);

        //System.out.println(personService.getById(1));

//        List<Academy> academies = personService.getAllAcademys();
//        academies.forEach(System.out::println);

        context.close();

    }
}
