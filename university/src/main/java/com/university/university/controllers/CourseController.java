package com.university.university.controllers;

import com.university.university.dto.AddCourseDTO;
import com.university.university.dto.CourseDTO;
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
    public ResponseEntity<?> courseList(){
        ModelMap modelMap = new ModelMap();

        List<CourseDTO> courselist =(List<CourseDTO>) this.courseService.getCourseList();
        if(courselist==null){
            modelMap.addAttribute("message","No Courses Available");
        }
        else{

        modelMap.addAttribute("message","Course List Successfully Fetched");
        modelMap.addAttribute("data",courselist);
        }
        return ResponseEntity.ok(modelMap);
    }


    @GetMapping("/course/details/{coursecode}")
    public ResponseEntity<?> getCourseDetails(@PathVariable ("coursecode") String coursecode){
        ModelMap model = new ModelMap();
        CourseDTO details = this.courseService.getCourseDetails(coursecode);
        if(details==null){
            model.addAttribute("messages","Course does not exist");
        }else{
            model.addAttribute("messages","Course Details successfully fetched");
            model.addAttribute("details",details);
        }
return ResponseEntity.ok(model);
    }

    @PostMapping("/course/add")
    public ResponseEntity<?> addCourse(@RequestBody AddCourseDTO course){
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
