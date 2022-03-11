package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration // Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime, for example:
public class StudentConfig {


    // The bean is basically an instantiation of a class that is being handled by the Spring container for the duration of
    // its lifecycle. It will be implemented where needed through IoC (inversion of control) and is created as soon
    // as the Spring Boot application is started.
    @Bean

    /* CommandLineRunner is an interface used to indicate that a bean
    should run when it is contained within a SpringApplication.
    A Spring Boot application can have multiple beans implementing CommandLineRunner.
    These can be ordered with @Order.
     */
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
            );

            repository.saveAll(
            List.of(mariam, alex)
                    );
        };
    }
}
