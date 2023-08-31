package com.studentservice.courses.service;

import com.studentservice.courses.dao.CourseDao;
import com.studentservice.courses.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getCourseByStudnetId(Integer studentId);
    CourseDTO createCourse(CourseDTO courseDTO);
}
