package com.studentservice.courses.controllers;


import com.studentservice.courses.dto.CourseDTO;
import com.studentservice.courses.dto.CourseWrapper;
import com.studentservice.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping(value = "/{studentId}")
    public ResponseEntity<CourseWrapper> getCourseByStudentId(@PathVariable("studentId")final Integer studentId){
        CourseWrapper courseWrapper = new CourseWrapper();
        courseWrapper.setCourseDTO(courseService.getCourseByStudnetId(studentId));
            return  new ResponseEntity<>(courseWrapper, HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO courseDTO){
        return  new ResponseEntity<>(courseService.createCourse(courseDTO),HttpStatus.CREATED);
    }
}
