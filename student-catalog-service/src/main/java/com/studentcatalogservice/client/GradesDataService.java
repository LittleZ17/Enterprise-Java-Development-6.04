package com.studentcatalogservice.client;

import com.studentcatalogservice.model.Course;
import com.studentcatalogservice.model.CourseGrade;
import com.studentcatalogservice.model.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient("grades-data-service")
public interface GradesDataService {
    @GetMapping("/api/grades")
    public List<Grade> getAllGrades();

    @GetMapping("/api/course/{courseCode}")
    public Course getCourseByCourseCode(@PathVariable String courseCode);

    @GetMapping("/api/course/{courseCode}/grades")
    @ResponseStatus(HttpStatus.OK)
    public CourseGrade getGradesByCourseCode(@PathVariable String courseCode);

}
