package com.studentservice.result.populator;

import com.studentservice.result.dto.ResultDTO;
import com.studentservice.result.model.ResultModel;

public interface ResultPopulator {
    ResultDTO populate(ResultModel resultModel);
    ResultModel reversePopulate(ResultDTO resultDTO);
}
