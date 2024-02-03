package com.example.demo.repository;

import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    helper method, which wil perform this SELECT * FROM student Where email =? or use Query annotation
    @Query("SELECT s FROM Student s Where s.email =?1")
    Optional<Student> findStudentByEmail(String email);
}
