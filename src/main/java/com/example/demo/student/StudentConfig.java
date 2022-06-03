package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student mariam = new Student(
          "Mariam",
          "mariam.jafar@gmail.com",
          LocalDate.of(1979, Month.JUNE, 6),
          21);

      Student frank = new Student(
          "Frank",
          "frank.goke@gmail.com",
          LocalDate.of(2001, Month.APRIL, 6),
          31);

      repository.saveAll(
          List.of(mariam, frank));
    };
  }

}
