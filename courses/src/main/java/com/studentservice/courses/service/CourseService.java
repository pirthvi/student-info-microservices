package com.studentservice.courses.service;

import com.studentservice.courses.dao.CourseDao;
import com.studentservice.courses.dto.CourseDTO;
import com.studentservice.courses.dto.CourseWrapper;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getCourseByStudnetId(Integer studentId);
    CourseWrapper createCourse(CourseWrapper courseWrapper);
}
