package com.studentservice.result.populator.impl;

import com.studentservice.result.dto.ResultDTO;
import com.studentservice.result.model.ResultModel;
import com.studentservice.result.populator.ResultPopulator;
import org.springframework.stereotype.Component;

@Component
public class ResultPopulatorImpl implements ResultPopulator {

    @Override
    public ResultDTO populate(ResultModel resultModel) {
        ResultDTO resultDTO= new ResultDTO();
        resultDTO.setId(resultModel.getId());
        resultDTO.setBiologyMarksObtained(resultModel.getBiologyMarksObtained());
        resultDTO.setChemistryMarksObtained(resultModel.getChemistryMarksObtained());
        resultDTO.setEnglishMarksObtained(resultModel.getEnglishMarksObtained());
        resultDTO.setMathematicsMarksObtained(resultModel.getMathematicsMarksObtained());
        resultDTO.setMinor1MarksObtained(resultModel.getMinor1MarksObtained());
        resultDTO.setMinor2MarksObtained(resultModel.getMinor2MarksObtained());
        resultDTO.setPhysicsMarksObtained(resultModel.getPhysicsMarksObtained());
        resultDTO.setStudentId(resultModel.getStudentId());
        return resultDTO;
    }

    @Override
    public ResultModel reversePopulate(ResultDTO resultDTO) {
        ResultModel resultModel = new ResultModel();
        resultModel.setBiologyMarksObtained(resultDTO.getBiologyMarksObtained());
        resultModel.setChemistryMarksObtained(resultDTO.getChemistryMarksObtained());
        resultModel.setEnglishMarksObtained(resultDTO.getEnglishMarksObtained());
        resultModel.setMathematicsMarksObtained(resultDTO.getMathematicsMarksObtained());
        resultModel.setPhysicsMarksObtained(resultDTO.getPhysicsMarksObtained());
        resultModel.setMinor1MarksObtained(resultDTO.getMinor1MarksObtained());
        resultModel.setMinor2MarksObtained(resultDTO.getMinor2MarksObtained());
        resultModel.setStudentId(resultDTO.getStudentId());
        return resultModel;
    }
}
