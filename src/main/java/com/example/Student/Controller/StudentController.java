package com.example.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Model.Student;
import com.example.Student.Service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    //GetAll Rest Api
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    //Get by Id Rest Api
    @GetMapping("/{id}")
    // localhost:8080/api/Student/1
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id,@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student, id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
    //delete Student from db
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

}
