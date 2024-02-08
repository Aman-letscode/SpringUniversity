package com.university.university.services;

import com.university.university.entities.Course;
import com.university.university.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getCourseList(){
        List<Course> courselist = null;
        try{
            courselist = (List<Course>) this.courseRepository.findAll();

        }catch (Exception e){
            e.printStackTrace();
        }
        return courselist;
    }

    public String addCourse(Course course){
        Course result = null;
        try{
            Course courseWithSameCode = (Course) this.courseRepository.findAllByCourseCode(course.getCourseCode());
            if(courseWithSameCode!=null){
                return "Course Code already present";
            }
            Course courseWithSameName = (Course) this.courseRepository.findAllByCourseName(course.getCourseName());
            if(courseWithSameCode!=null){
                return "Course Name already present";
            }

            result = (Course) this.courseRepository.save(course);

        }catch (Exception e){
            e.printStackTrace();
            return "Not able to save the course";
        }
        return "failed";
    }
}
