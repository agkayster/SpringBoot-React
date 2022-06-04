package com.example.demo.student;

// import java.time.LocalDate;
// import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

  // This is the service to provide the Post method//
  public void addNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    studentRepository.save(student);
  }

  // This is the service to provide the Delete method//
  public void deleteStudent(Long studentId) {
    // studentRepository.findById(studentId);
    boolean exists = studentRepository.existsById(studentId);

    if (!exists) {
      throw new IllegalStateException("student with id " + studentId + " does not exist");
    }
    studentRepository.deleteById(studentId);
  }

  @Transactional
  public void updateStudent(Long studentId, String name, String email) {
    Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
    if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
      student.setName(name);
    }

    if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
      Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
      if (studentOptional.isPresent()) {
        throw new IllegalStateException("email taken");
      }
      student.setEmail(email);
    }
  }
}
