package com.university.university.controllers;

import com.university.university.entities.Course;
import com.university.university.services.CourseService;
import org.springframework. beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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


    @GetMapping("/course/details/{id}")
    public ResponseEntity<ModelMap> getCourseDetails(@PathVariable ("id") int id){
        ModelMap model = new ModelMap();
        Course details = this.courseService.getCourseDetails(id);
        if(details==null){
            model.addAttribute("messages","Course does not exist");
        }else{
            model.addAttribute("messages","Course Details successfully fetched");
            model.addAttribute("details",details);
        }
return ResponseEntity.ok(model);
    }

    @PostMapping("/course/add")
    public ResponseEntity<ModelMap> addCourse(@RequestBody Course course){
        ModelMap model = new ModelMap();
        System.out.println(course.toString());
        if(course.getCourseCode()==null){
            model.addAttribute("status","failed");
            model.addAttribute("messages","No Course send by the client");
        }else{

        String response = this.courseService.addCourse(course);
        if(response.contains("Successfully")){
            model.addAttribute("status","success");
            model.addAttribute("messages",response);
        }
        else{
            model.addAttribute("status","failed");
            model.addAttribute("messages",response);
        }
        }
        return ResponseEntity.ok(model);
    }

}
