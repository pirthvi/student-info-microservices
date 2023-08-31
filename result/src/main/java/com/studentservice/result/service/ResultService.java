package com.studentservice.result.service;

import com.studentservice.result.dto.ResultDTO;

public interface ResultService {

    ResultDTO getResultByStudentId(Integer id);
    ResultDTO createResult(ResultDTO resultDTO);
}
