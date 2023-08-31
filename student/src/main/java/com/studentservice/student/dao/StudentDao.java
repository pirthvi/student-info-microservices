package com.studentservice.student.dao;

import com.studentservice.student.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<StudentModel,Integer> {
}
