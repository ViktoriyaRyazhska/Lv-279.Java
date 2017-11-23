package ua.softserve;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ua.softserve.config.DataConfig;

import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.dao.LanguageTranslationsDAO;
import ua.softserve.persistence.dao.StudentRepository;
import ua.softserve.persistence.entity.Student;


import java.awt.print.Pageable;
import java.util.List;


public class MainPersistence {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);
    }

}