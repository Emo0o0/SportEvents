package com.example.sportevents.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.sportevents"})
@EntityScan(basePackages = {"com.example.sportevents.persistence.entities"})
@EnableJpaRepositories(basePackages = {"com.example.sportevents.persistence.repository"})
public class SportEventsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SportEventsApplication.class, args);
    }
}
