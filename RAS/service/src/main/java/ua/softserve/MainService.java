package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.config.ServiceConf;

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

        StudentService studentService = context.getBean(StudentService.class);

        List<StudentsViewDto> list = studentService.getAllStudentsOfAcademy(796);

       list.forEach(x-> System.out.println(x.getStudentId()));

//        HistoryService historyService = context.getBean(HistoryService.class);
//
//        for (History history:historyService.findByCrmGroup(428)) {
//            System.out.println(history.toString());
//
//        }

        AcademyService bean = context.getBean(AcademyService.class);
        System.out.println(bean.findWithEmployeeExperts(1).getExperts());

    }

}