package com.studentservice.courses.populator;

import com.studentservice.courses.dto.CourseDTO;
import com.studentservice.courses.model.CourseModel;

public interface CoursePopulator {

    CourseDTO populate(CourseModel courseModel);
    CourseModel reversePopulate(CourseDTO courseDTO);
}
