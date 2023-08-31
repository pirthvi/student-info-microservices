package com.studentservice.student.controllers;

import com.studentservice.student.dtos.StudentDTO;
import com.studentservice.student.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDTO>> getAll(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.createStudent(studentDTO),HttpStatus.CREATED);
    }
}
