package com.university.university.controllers;

import com.university.university.entities.Student;
import com.university.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> list = this.studentService.allStudents();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable ("id") int id){
        Optional<Student> result = this.studentService.findStudentById(id);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(result);
    }

//    @PostMapping("/register")
//    public Student createStudent(@RequestBody Student student){
//        return this.studentService.addStudent(student);
//    }


    @DeleteMapping("/students/{Id}")
    public ResponseEntity<List<Student>> deleteStudentData(@PathVariable ("Id") int Id){

        List<Student> result = this.studentService.allStudents();
        List<Student> result1 = this.studentService.deleteStudentById(Id);
        if(result.size()==result1.size()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(result1));

    }


    @PutMapping("/students/{Id}")
    public Student updateStudentData(@RequestBody Student student ,@PathVariable ("Id") int Id){
        student = this.studentService.updateStudent(student, Id);
        return student;
    }




}
