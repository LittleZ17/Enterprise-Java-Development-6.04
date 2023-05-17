package com.studentcatalogservice.service.impl;

import com.studentcatalogservice.client.GradesDataService;
import com.studentcatalogservice.client.StudentInfoService;
import com.studentcatalogservice.model.*;
import com.studentcatalogservice.service.interfaces.ICatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CatalogService implements ICatalogService {

    @Autowired
    GradesDataService gradesDataService;

    @Autowired
    StudentInfoService studentInfoService;

    @Override
    public Catalog getCatalog(String courseCode) {

        Course course = gradesDataService.getCourseByCourseCode(courseCode);
        CourseGrade courseGrade = gradesDataService.getGradesByCourseCode(courseCode);
        String port = studentInfoService.getStudentInfo();
        log.info("Running port ----> " + port);

        Catalog catalog = new Catalog();
        catalog.setCourseCode(course.getCodeCourse());
        List<StudentGrade> studentGrades = new ArrayList<>();

        for (Grade grade : courseGrade.getGrades()){

            Student student = studentInfoService.getStudentInfo(grade.getStudentId());
            studentGrades.add(new StudentGrade(student.getName(), student.getAge(), grade.getGrade()));
        }
        catalog.setStudentGrades(studentGrades);
        return catalog;
    }
}
