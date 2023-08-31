package com.studentservice.courses.populator.impl;

import com.studentservice.courses.dto.CourseDTO;
import com.studentservice.courses.model.CourseModel;
import com.studentservice.courses.populator.CoursePopulator;
import org.springframework.stereotype.Component;

@Component
public class CoursePopulatorImpl implements CoursePopulator {
    @Override
    public CourseDTO populate(CourseModel courseModel) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setStudentId(courseModel.getStudentId());
        courseDTO.setSubjectDescription(courseModel.getSubjectDescription());
        courseDTO.setSubjectName(courseModel.getSubjectName());
        return courseDTO;
    }

    @Override
    public CourseModel reversePopulate(CourseDTO courseDTO) {
        CourseModel courseModel = new CourseModel();
        courseModel.setSubjectDescription(courseDTO.getSubjectDescription());
        courseModel.setSubjectName(courseDTO.getSubjectName());
        courseModel.setStudentId(courseDTO.getStudentId());
        return courseModel;
    }
}
