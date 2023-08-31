package com.studentservice.result.dao;

import com.studentservice.result.model.ResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultDao extends JpaRepository<ResultModel,Integer> {
    List<ResultModel> findByStudentId(Integer studentId);

}
