package com.example.demo.Configuration;

import com.example.demo.repository.StudentRepository;
import com.example.demo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
           Student mpho = new Student(
                    "Mpho",
                    "mpho@example.com",
                    LocalDate.of(1997, JANUARY, 7)
            );
            Student karabo = new Student(
                    "Karabo",
                    "karabo@example.com",
                    LocalDate.of(2019, JULY, 26)
            );

            repository.saveAll(
                    List.of(mpho, karabo)
            );
        };
    }
}
