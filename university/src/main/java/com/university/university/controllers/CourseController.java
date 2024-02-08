package com.university.university.controllers;

import com.university.university.entities.Course;
import com.university.university.services.CourseService;
import org.springframework. beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/course/list")
    public ResponseEntity<ModelMap> courseList(){
        ModelMap modelMap = new ModelMap();

        List<Course> courselist =(List<Course>) this.courseService.getCourseList();
        if(courselist==null){
            modelMap.addAttribute("message","No Courses Available");
        }
        else{

        modelMap.addAttribute("message","Course List Successfully Fetched");
        modelMap.addAttribute("data",courselist);
        }
        return ResponseEntity.ok(modelMap);
    }
}
