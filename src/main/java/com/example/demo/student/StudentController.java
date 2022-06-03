package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This allows the class function below it to serve RESTfUll endpoints//
@RequestMapping(path = "api/v1/student") // Our API layer//

// This will hold all our resources for the API//
public class StudentController {

  // References the StudentService class//
  private final StudentService studentService;

  // Autowired allows us to pass StudentService automatically into the controller
  // method below//
  @Autowired
  // We pass the StudentService inside the StudentController//
  public StudentController(StudentService studentService) {
    // this.studentService = new StudentService(); // will work but should not be
    // used, instead use dependency injection/
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getStudents();
  }
}
