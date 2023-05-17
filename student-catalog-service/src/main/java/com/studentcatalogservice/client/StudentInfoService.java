package com.studentcatalogservice.client;

import com.studentcatalogservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("student-info-service")
public interface StudentInfoService {
    @GetMapping("/api/student/{id}")
    public Student getStudentInfo(@PathVariable String id);

    @GetMapping("/api/student/test")
    String getStudentInfo();
}
