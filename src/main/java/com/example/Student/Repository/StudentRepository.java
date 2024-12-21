package com.example.Student.Repository;

import java.util.List;

import com.example.Student.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface StudentRepository extends MongoRepository<Student,String>{

    //find students by year of entrollment
    List<Student> findByEnrollmentYear(int year);

    //Find students by department using method query
    List<Student> findByDepartment(String department);

    @Query("{ 'email': ?0}")
    Student findByEmail(String email);

    @Query("{ 'department': ?0, 'yearOfEntrollment': ?1 }")
    List<Student> findByDepartmentAndYearOfEnrollment(String department, int year);

}
