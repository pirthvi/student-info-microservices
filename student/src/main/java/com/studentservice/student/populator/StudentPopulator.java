package com.studentservice.student.populator;

import com.studentservice.student.dtos.CourseDTO;
import com.studentservice.student.dtos.ResultDTO;
import com.studentservice.student.dtos.StudentDTO;
import com.studentservice.student.models.StudentModel;

public interface StudentPopulator {
    StudentDTO populate(StudentModel studentModel);
    StudentModel reversePopulate(StudentDTO studentDTO);

}
