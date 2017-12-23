/*
 * asd
 *
 * Version 1.0-SNAPSHOT
 *
 * 12.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ua.softserve")
@EntityScan(value = "ua.softserve")
public class PersistenceConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceConfiguration.class, args);
    }

}