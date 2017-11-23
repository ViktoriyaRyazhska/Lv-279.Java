package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.config.ServiceConf;

import ua.softserve.persistence.dto.HistoryDTO;
import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.persistence.entity.History;
import ua.softserve.persistence.entity.Mark;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.*;

import ua.softserve.service.LanguageTranslationsService;

import java.util.List;


public class MainService {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceConf.class, DataConfig.class);

    }
}