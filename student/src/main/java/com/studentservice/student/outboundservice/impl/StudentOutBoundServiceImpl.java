package com.studentservice.student.outboundservice.impl;

import com.studentservice.student.dtos.CourseWrapper;
import com.studentservice.student.dtos.ResultDTO;
import com.studentservice.student.outboundservice.StudentOutBoundService;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Override
    public ResultDTO createStudentResult(ResultDTO resultDTO) {
        HttpEntity<ResultDTO> request= new HttpEntity<>(resultDTO,getHeaders());
        ResultDTO resultDtoResponse= restTemplate.exchange("http://RESULT-SERVICE/result/create", HttpMethod.POST,request,ResultDTO.class).getBody();

        return resultDtoResponse;
    }

    @Override
    public CourseWrapper createStudentCourse(CourseWrapper courseWrapper) {
        HttpEntity<CourseWrapper> courseRequest= new HttpEntity<>(courseWrapper,getHeaders());

        CourseWrapper courseWrapperResponse=  restTemplate.exchange("http://COURSE-SERVICE/course/create",HttpMethod.POST,courseRequest, CourseWrapper.class).getBody();
        return courseWrapperResponse;

    }

    @Override
    public ResultDTO getStudentResult(Integer studentId) {
        ResultDTO resultDTO=restTemplate.getForObject("http://RESULT-SERVICE/result/"+studentId,ResultDTO.class);
        return resultDTO;
    }

    @Override
    public CourseWrapper getStudentCourses(Integer studentId) {
        CourseWrapper courseWrapper= restTemplate.getForObject("http://COURSE-SERVICE/course/"+studentId,CourseWrapper.class);
        return courseWrapper;

    }

    protected HttpHeaders getHeaders(){
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return headers;


    }
}
