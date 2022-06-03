package com.example.demo.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

  private Long id;
  private String name;
  private String email;
  private LocalDate dob;
  private int age;

  // // Constructor that is empty
  public Student() {
  }

  // Constructor that has all the details
  public Student(Long id, String name, String email, LocalDate dob, int age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.age = age;
  }

  // // Constructor without the "id" property because it will be generated
  // // automatically//
  public Student(String name, String email, LocalDate dob, int age) {
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.age = age;
  }

  // Here we create Getters and Setters//
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name = '" + name + '\'' +
        ", email = '" + email + '\'' +
        ", dob = " + dob +
        ", age = " + age +
        '}';

  }
}