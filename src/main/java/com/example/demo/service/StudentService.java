package com.example.demo.service;

import com.example.demo.repository.StudentRepository;
import com.example.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
          if(studentByEmail.isPresent()){
              throw new IllegalStateException("email exist");
          }
          studentRepository.save(student);
    }

    public void deleteStudent(long studentId) {
//        studentRepository.findAllById(studentId);
      boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+ studentId +" does not exists.");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new IllegalStateException(
                "student with id "+ studentId +"does not exists."));

          if(name !=null && !name.isEmpty() && !Objects.equals(student.getName(), name)){
                student.setName(name);
          }



          if(email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)){
              Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
              if(studentOptional.isPresent()){
                  throw new IllegalStateException("email already exists.");
              }
              student.setEmail(email);
          }
            studentRepository.save(student);
    }
}
