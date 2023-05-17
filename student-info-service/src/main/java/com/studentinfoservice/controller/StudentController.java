package com.studentinfoservice.controller;


import com.studentinfoservice.model.Student;
import com.studentinfoservice.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentInfo(@PathVariable String id){
        log.info("PORT is: " + port);
        return studentRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @GetMapping("/student/test")
    @ResponseStatus(HttpStatus.OK)
    public String getStudentInfo(){
        log.info(("PORT is...: " + port));
        return port;
    }
}
