package com.example.Student.Repository;

import java.util.List;

import com.example.Student.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String>{

    List<Student> findByYearOfEnrollment(Integer yearOfEntrollment);

    String findDepartmentById(String id);

    void deleteByYearOfEnrollment(Integer yearOfEnrollment);

}
