package ua.softserve;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;

import ua.softserve.persistence.dao.LanguageTranslationsDAO;


public class MainPersistence {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);
    }

}