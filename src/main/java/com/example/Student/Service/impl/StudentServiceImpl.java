package com.example.Student.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Student.Model.Student;
import com.example.Student.Repository.StudentRepository;
import com.example.Student.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
 
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
 
    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
 //update employee
    @Override
    public Student updateStudent(Student student, String id) {
        Student existingStudent =getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());//Corrected method call
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setEntrollmentYear(student.getEntrollmentYear());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent (String id) {
        studentRepository.deleteById(id);
    }


    @Override
    public List<Student> getStudentByYearOfEnrollment(Integer yearOfEntrollment) {
        return studentRepository.findByYearOfEnrollment(yearOfEntrollment);
    }


    @Override
    public String getDepartmentById(String id) {
        return studentRepository.findDepartmentById(id);
    }

    @Transactional
    @Override
    public void removeStudentByYearOfEntrollment(Integer yearOfEnrollment) {
        studentRepository.deleteByYearOfEnrollment(yearOfEnrollment);
    }

}
