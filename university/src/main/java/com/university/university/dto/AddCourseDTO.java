package com.university.university.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCourseDTO {

    private String courseCode;
    private String courseName;
    private int duration;
    private String description;

}
