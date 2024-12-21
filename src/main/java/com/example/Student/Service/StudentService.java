package com.example.Student.Service;

import java.util.List;

import com.example.Student.Model.Student;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(String id);
    Student updateStudent(Student student,String id);
    void deleteStudent(String id);

}
