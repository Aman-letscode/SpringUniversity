package com.university.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private String courseCode;
    private String courseName;
    private int duration;
    private String description;
    private LocalDate createdAt;
}
