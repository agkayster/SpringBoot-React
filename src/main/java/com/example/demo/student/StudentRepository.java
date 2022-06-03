package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository is always used to access the Database//
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
