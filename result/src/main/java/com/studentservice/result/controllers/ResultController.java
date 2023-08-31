package com.studentservice.result.controllers;

import com.studentservice.result.dto.ResultDTO;
import com.studentservice.result.service.ResultService;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    ResultService resultService;
    @GetMapping(value = "/{studentId}")
    public ResponseEntity<ResultDTO> getResultById(@PathVariable("studentId") Integer studentId){
        return  new ResponseEntity<>(resultService.getResultByStudentId(studentId), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public  ResponseEntity<ResultDTO> createResult(@RequestBody ResultDTO resultDTO){

        return  new ResponseEntity<>(resultService.createResult(resultDTO),HttpStatus.CREATED);

    }
}

