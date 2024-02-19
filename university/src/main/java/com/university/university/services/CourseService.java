package com.university.university.services;

import com.university.university.dto.AddCourseDTO;
import com.university.university.dto.CourseDTO;
import com.university.university.entities.Course;
import com.university.university.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    public List<CourseDTO> getCourseList(){
            List<CourseDTO> result = new ArrayList<>();
        try{
        List<Course> courselist = null;
            courselist = (List<Course>) this.courseRepository.findAll();
            courselist.forEach(course -> {
                result.add(new CourseDTO(
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getDuration(),
                        course.getDescription(),
                        course.getCreatedAt().toLocalDate()));
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public String addCourse(AddCourseDTO course){
        Course result = null;
        try{
            Course courseWithSameCode = (Course) this.courseRepository.findAllByCourseCode(course.getCourseCode());
            if(courseWithSameCode!=null){
                return "Course Code already present";
            }
            Course courseWithSameName = (Course) this.courseRepository.findAllByCourseName(course.getCourseName());
            if(courseWithSameName!=null){
                return "Course Name already present";
            }

           result= (Course) this.courseRepository.save(new Course(course.getCourseCode(),course.getCourseName(),course.getDuration(),course.getDescription()));

        }catch (Exception e){
            e.printStackTrace();
            return "Not able to save the course";
        }
        return "Successfully Saved";
    }


    public CourseDTO getCourseDetails(String coursecode){
        CourseDTO result = null;
        try{
            Course course = (Course) courseRepository.findAllByCourseCode(coursecode);
            result= new CourseDTO(
                    course.getCourseCode(),
                    course.getCourseName(),
                    course.getDuration(),
                    course.getDescription(),
                    course.getCreatedAt().toLocalDate());
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

