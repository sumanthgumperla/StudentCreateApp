package com.library.librarystudent.controller;

import com.library.librarystudent.exception.StudentDataNotFoundException;
import com.library.librarystudent.model.StudentOutPut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(StudentDataNotFoundException.class)
    public ResponseEntity<StudentOutPut> catchUserDefinedException(StudentDataNotFoundException exe){
        System.out.println(exe);
        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(NullPointerException.class)
    public void handleNullPointerException(NullPointerException ex){
        System.out.println(ex.getMessage());
        // send email
    }

    @ExceptionHandler(Exception.class)
    public void handleAllOther(Exception ex){
        System.out.println(ex.getMessage());
        // handle all exceptions`
    }


}
