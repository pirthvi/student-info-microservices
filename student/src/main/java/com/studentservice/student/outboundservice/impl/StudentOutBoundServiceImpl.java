package com.studentservice.student.outboundservice.impl;

import com.studentservice.student.dtos.CourseWrapper;
import com.studentservice.student.dtos.ResultDTO;
import com.studentservice.student.outboundservice.StudentOutBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class StudentOutBoundServiceImpl implements StudentOutBoundService {
    @Autowired
    RestTemplate restTemplate;
   @Value("${com.student.service.result.service.create.url}")
    String  RESULT_SERVICE_CREATE_URL;
    @Value("${com.student.service.course.service.create.url}")
    String COURSE_SERVICE_CREATE_URL;
   @Value("${com.student.service.result.service.get.url}")
    String RESULT_SERVICE_GET_URL;
    @Value("${com.student.service.course.service.get.url}")
    String COURSE_SERVICE_GET_URL;




    @Override
    public ResultDTO createStudentResult(ResultDTO resultDTO) {
        HttpEntity<ResultDTO> request= new HttpEntity<>(resultDTO,getHeaders());
        ResultDTO resultDtoResponse= restTemplate.exchange(RESULT_SERVICE_CREATE_URL, HttpMethod.POST,request,ResultDTO.class).getBody();

        return resultDtoResponse;
    }

    @Override
    public CourseWrapper createStudentCourse(CourseWrapper courseWrapper) {
        HttpEntity<CourseWrapper> courseRequest= new HttpEntity<>(courseWrapper,getHeaders());

        CourseWrapper courseWrapperResponse=  restTemplate.exchange(COURSE_SERVICE_CREATE_URL,HttpMethod.POST,courseRequest, CourseWrapper.class).getBody();
        return courseWrapperResponse;

    }

    @Override
    public ResultDTO getStudentResult(Integer studentId) {
        ResultDTO resultDTO=restTemplate.getForObject(RESULT_SERVICE_GET_URL+studentId,ResultDTO.class);
        return resultDTO;
    }

    @Override
    public CourseWrapper getStudentCourses(Integer studentId) {
        CourseWrapper courseWrapper= restTemplate.getForObject(COURSE_SERVICE_GET_URL+studentId,CourseWrapper.class);
        return courseWrapper;

    }

    protected HttpHeaders getHeaders(){
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return headers;


    }
}
