package com.studentservice.student.outboundservice;

import com.studentservice.student.dtos.CourseWrapper;
import com.studentservice.student.dtos.ResultDTO;

public interface StudentOutBoundService {
    ResultDTO createStudentResult(ResultDTO resultDTO);
    CourseWrapper createStudentCourse(CourseWrapper courseWrapper);
    ResultDTO getStudentResult(Integer studentId);
    CourseWrapper getStudentCourses(Integer studentId);
}
