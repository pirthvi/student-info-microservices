package com.studentservice.student.service.impl;

import com.studentservice.student.dao.StudentDao;
import com.studentservice.student.dtos.CourseWrapper;
import com.studentservice.student.dtos.ResultDTO;
import com.studentservice.student.dtos.StudentDTO;
import com.studentservice.student.models.StudentModel;
import com.studentservice.student.populator.StudentPopulator;
import com.studentservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentPopulator studentPopulator;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
       return  studentPopulator.populate(studentDao.save(studentPopulator.reversePopulate(studentDTO)));

    }

    @Override
    public List<StudentDTO> getStudents() {
        List<StudentModel> studentModels = studentDao.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(StudentModel student : studentModels){
            ResultDTO resultDTO = restTemplate.getForObject("http://RESULT-SERVICE/result/"+student.getId(),ResultDTO.class);
            StudentDTO studentDTO= studentPopulator.populate(student);
            CourseWrapper courseWrapper= restTemplate.getForObject("http://COURSE-SERVICE/course/"+student.getId(),CourseWrapper.class);

            studentDTO.setCourseDTOList(courseWrapper.getCourseDTO());
            studentDTO.setResultDTO(resultDTO);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }
}
