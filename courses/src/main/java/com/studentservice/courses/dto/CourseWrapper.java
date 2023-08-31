package com.studentservice.courses.dto;

import java.util.List;

public class CourseWrapper {
    List<CourseDTO> courseDTO;

    public List<CourseDTO> getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(List<CourseDTO> courseDTO) {
        this.courseDTO = courseDTO;
    }
}
