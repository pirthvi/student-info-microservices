package com.studentservice.courses.service.impl;

import com.studentservice.courses.dao.CourseDao;
import com.studentservice.courses.dto.CourseDTO;
import com.studentservice.courses.model.CourseModel;
import com.studentservice.courses.populator.CoursePopulator;
import com.studentservice.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Autowired
    CoursePopulator coursePopulator;
    @Override
    public List<CourseDTO> getCourseByStudnetId(Integer studentId) {
        List<CourseDTO> courseDTOS = new ArrayList<>();
        List<CourseModel> courseModels = courseDao.findByStudentId(studentId);
        for(CourseModel courseModel: courseModels){
            CourseDTO courseDTO = coursePopulator.populate(courseModel);
            courseDTOS.add(courseDTO);

        }
        return courseDTOS;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        return coursePopulator.populate(courseDao.save(coursePopulator.reversePopulate(courseDTO)));
    }
}
