package ua.softserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.softserve.config.DataConfig;
import ua.softserve.config.ServiceConf;
import ua.softserve.config.WebInit;
import ua.softserve.service.EmployeeService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceConf.class, DataConfig.class);

        EmployeeService employeeService= context.getBean(EmployeeService.class);
        System.out.println(employeeService.findAllEmployees());
    }

}