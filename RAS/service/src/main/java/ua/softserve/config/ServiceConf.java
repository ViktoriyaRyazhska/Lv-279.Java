/*
* ServiceConf
*
* Version 1.0-SNAPSHOT
*
* 17.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.softserve.service.UserService;
import ua.softserve.service.impl.UserServiceImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan("ua.softserve.service")
public class ServiceConf {

}
