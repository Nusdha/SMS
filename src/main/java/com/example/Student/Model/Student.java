package com.example.Student.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "Student")
@Data
@Builder
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private int entrollmentYear;


    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEntrollmentYear(int entrollmentYear) {
        this.entrollmentYear = entrollmentYear;
    }
}
