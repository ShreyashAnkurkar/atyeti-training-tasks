package org.atyeti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class EmployeeManagementRestApiTask2 {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementRestApiTask2.class, args);
    }

}
