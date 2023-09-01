package com.studentservice.student.dtos;

import java.util.List;

public class CourseWrapper {
    List<CourseDTO> courseDTO;
    Integer studentId;
    public List<CourseDTO> getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(List<CourseDTO> courseDTO) {
        this.courseDTO = courseDTO;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
