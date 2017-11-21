package ua.softserve;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.dao.LanguageTranslationsDAO;


import java.util.List;

public class MainPersistence {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);
    }

}