package com.tutorial.springdemo.advice;

import com.tutorial.springdemo.entity.StudentErrorResponse;
import com.tutorial.springdemo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //---------Global Rest Controller Exception Handling (over all controllers)--------------------------------------

    //Student not found
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
        //create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(ex.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        //return a Response Entity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    //Any other Exceptions ()
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
        //create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(ex.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        //return a Response Entity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
