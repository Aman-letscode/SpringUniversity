package com.university.university.repositories;

import com.university.university.entities.Course;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer> {

    Object findAllByCourseCode(String courseCode);

    Object findAllByCourseName(String courseName);
}
