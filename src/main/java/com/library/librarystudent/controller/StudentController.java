package com.library.librarystudent.controller;

import com.library.librarystudent.model.Student;
import com.library.librarystudent.model.StudentOutPut;
import com.library.librarystudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("getstudent/{Id}")
    public ResponseEntity<StudentOutPut> getStudentDetails(@PathVariable Integer Id){

    StudentOutPut studentOutPut = studentService.getStudentDetails(Id);
        return ResponseEntity.ok(studentOutPut);

    }

}
