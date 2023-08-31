package com.studentservice.student.populator.impl;

import com.studentservice.student.dtos.StudentDTO;
import com.studentservice.student.models.StudentModel;
import com.studentservice.student.populator.StudentPopulator;
import org.springframework.stereotype.Component;

@Component
public class StudentPopulatorImpl implements StudentPopulator {
    @Override
    public StudentDTO populate(StudentModel studentModel) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentModel.getId());
        studentDTO.setName(studentModel.getName());
        studentDTO.setAddress(studentModel.getAddress());
        studentDTO.setEmail(studentModel.getEmail());
        studentDTO.setGender(studentModel.getGender());
        studentDTO.setFatherName(studentModel.getFatherName());
        studentDTO.setMobileNo(studentModel.getMobileNo());
        studentDTO.setDateOfBirth(studentModel.getDateOfBirth());
        return studentDTO;
    }

    @Override
    public StudentModel reversePopulate(StudentDTO studentDTO) {
        StudentModel studentModel = new StudentModel();
        studentModel.setAddress(studentDTO.getAddress());
        studentModel.setEmail(studentDTO.getEmail());
        studentModel.setFatherName(studentDTO.getFatherName());
        studentModel.setMobileNo(studentDTO.getMobileNo());
        studentModel.setGender(studentDTO.getGender());
        studentModel.setDateOfBirth(studentDTO.getDateOfBirth());
        studentModel.setName(studentDTO.getName());
        return studentModel;
    }
}
