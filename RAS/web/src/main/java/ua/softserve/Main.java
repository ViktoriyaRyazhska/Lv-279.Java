package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.config.ServiceConf;
import ua.softserve.config.WebInit;
import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.StudentService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceConf.class, DataConfig.class);

        StudentService studentService = context.getBean(StudentService.class);
        List<StudentsViewDto> students = studentService.getAllStudentsOfAcademy(796);
        System.out.println(students.size());
    }

}