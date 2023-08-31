package com.studentservice.result.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResultDTO {

    private Integer id;

    private String englishMarksObtained;
    private String biologyMarksObtained;
    private String chemistryMarksObtained;
    private String physicsMarksObtained;
    private String mathematicsMarksObtained;
    private String minor1MarksObtained;
    private String minor2MarksObtained;
    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglishMarksObtained() {
        return englishMarksObtained;
    }

    public void setEnglishMarksObtained(String englishMarksObtained) {
        this.englishMarksObtained = englishMarksObtained;
    }

    public String getBiologyMarksObtained() {
        return biologyMarksObtained;
    }

    public void setBiologyMarksObtained(String biologyMarksObtained) {
        this.biologyMarksObtained = biologyMarksObtained;
    }

    public String getChemistryMarksObtained() {
        return chemistryMarksObtained;
    }

    public void setChemistryMarksObtained(String chemistryMarksObtained) {
        this.chemistryMarksObtained = chemistryMarksObtained;
    }

    public String getPhysicsMarksObtained() {
        return physicsMarksObtained;
    }

    public void setPhysicsMarksObtained(String physicsMarksObtained) {
        this.physicsMarksObtained = physicsMarksObtained;
    }

    public String getMathematicsMarksObtained() {
        return mathematicsMarksObtained;
    }

    public void setMathematicsMarksObtained(String mathematicsMarksObtained) {
        this.mathematicsMarksObtained = mathematicsMarksObtained;
    }

    public String getMinor1MarksObtained() {
        return minor1MarksObtained;
    }

    public void setMinor1MarksObtained(String minor1MarksObtained) {
        this.minor1MarksObtained = minor1MarksObtained;
    }

    public String getMinor2MarksObtained() {
        return minor2MarksObtained;
    }

    public void setMinor2MarksObtained(String minor2MarksObtained) {
        this.minor2MarksObtained = minor2MarksObtained;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
