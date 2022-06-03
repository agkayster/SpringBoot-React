package com.example.demo.student;

// import java.time.LocalDate;
// import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// This is our Service layer//
@Service // describes this as a Service using the annotation//
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll(); // Data been given from the service layer to the API layer (controller)//
  }
}
