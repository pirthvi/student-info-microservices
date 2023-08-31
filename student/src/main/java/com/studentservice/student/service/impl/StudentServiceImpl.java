package com.studentservice.student.service.impl;

import com.studentservice.student.dao.StudentDao;
import com.studentservice.student.dtos.StudentDTO;
import com.studentservice.student.models.StudentModel;
import com.studentservice.student.populator.StudentPopulator;
import com.studentservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentPopulator studentPopulator;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
       return  studentPopulator.populate(studentDao.save(studentPopulator.reversePopulate(studentDTO)));

    }

    @Override
    public List<StudentDTO> getStudents() {
        List<StudentModel> studentModels = studentDao.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(StudentModel student : studentModels){
            studentDTOS.add(studentPopulator.populate(student));
        }
        return studentDTOS;
    }
}
