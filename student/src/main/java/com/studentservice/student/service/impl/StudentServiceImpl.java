package com.studentservice.student.service.impl;

import com.studentservice.student.dao.StudentDao;
import com.studentservice.student.dtos.CourseDTO;
import com.studentservice.student.dtos.CourseWrapper;
import com.studentservice.student.dtos.ResultDTO;
import com.studentservice.student.dtos.StudentDTO;
import com.studentservice.student.models.StudentModel;
import com.studentservice.student.outboundservice.StudentOutBoundService;
import com.studentservice.student.populator.StudentPopulator;
import com.studentservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentPopulator studentPopulator;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    StudentOutBoundService studentOutBoundService;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentDTO studentDTO1=studentPopulator.populate(studentDao.save(studentPopulator.reversePopulate(studentDTO)));
        ResultDTO resultDTO= studentDTO.getResultDTO();
        resultDTO.setStudentId(studentDTO1.getId());
        ResultDTO resultDTO1=studentOutBoundService.createStudentResult(resultDTO);
        studentDTO1.setResultDTO(resultDTO1);
        CourseWrapper courseWrapper= studentDTO.getCourses();
        courseWrapper.setStudentId(studentDTO1.getId());
        CourseWrapper courseWrapperResponse=  studentOutBoundService.createStudentCourse(courseWrapper);
        studentDTO1.setCourses(courseWrapperResponse);
        return studentDTO1;

    }

    @Override
    public List<StudentDTO> getStudents() {
        List<StudentModel> studentModels = studentDao.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(StudentModel student : studentModels){
            StudentDTO studentDTO= studentPopulator.populate(student);
            ResultDTO resultDTO = studentOutBoundService.getStudentResult(student.getId());
            CourseWrapper courseWrapper= studentOutBoundService.getStudentCourses(student.getId());
            studentDTO.setCourses(courseWrapper);
            studentDTO.setResultDTO(resultDTO);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

}
