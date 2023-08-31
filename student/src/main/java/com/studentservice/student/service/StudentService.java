package com.studentservice.student.service;

import com.studentservice.student.dtos.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudents();
}
