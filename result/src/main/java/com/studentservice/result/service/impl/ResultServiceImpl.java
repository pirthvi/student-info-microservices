package com.studentservice.result.service.impl;

import com.studentservice.result.dao.ResultDao;
import com.studentservice.result.dto.ResultDTO;
import com.studentservice.result.model.ResultModel;
import com.studentservice.result.populator.ResultPopulator;
import com.studentservice.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultDao resultDao;
    @Autowired
    ResultPopulator resultPopulator;

    @Override
    public ResultDTO getResultByStudentId(Integer id) {
        List<ResultModel> resultModels= resultDao.findByStudentId(id);
        if(!CollectionUtils.isEmpty(resultModels)){
            return resultPopulator.populate(resultDao.findByStudentId(id).get(0));
        }
        return  null;

    }

    @Override
    public ResultDTO createResult(ResultDTO resultDTO) {
        return resultPopulator.populate(resultDao.save(resultPopulator.reversePopulate(resultDTO)));
    }
}
