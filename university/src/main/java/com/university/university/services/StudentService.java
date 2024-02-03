package com.university.university.services;

import com.university.university.entities.Student;
import com.university.university.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentService {

//        private static List<Student> students = new ArrayList<>();
//
//        static{
//            students.add(new Student(123,"Aman","COmputer","Nagpur"));
//            students.add(new Student(345,"Aryaman","Electornics","Beed"));
//            students.add(new Student(453,"Sarthak","IT","Kalyan"));
//        }
//
//        public List<Student> allStudents(){
//
//            return students;
//        }
//        public List<Student> addStudent(Student s1){
//            students.add(s1);
//            System.out.println("Student added");
//            return students;
//        }
//
//        public Student findStudent(int Id){
//            Student ans = null;
//            try{
//
//            ans = students.stream().filter(e->e.getId()==Id).findFirst().get();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return ans;
//        }
//
//        public List<Student> deleteStudent(int Id){
////            try{
//            List<Student> deleted = students.stream().filter(e->e.getId()==Id).collect(Collectors.toList());
//            List<Student> newList = students.stream().filter(e->e.getId()!=Id).collect(Collectors.toList());
//            students = newList;
////
////            }catch (Exception e){
////                e.printStackTrace();
////            }
//            return deleted;
//        }
//
//    public Student updateStudent(Student data,int Id) {
//            Student student = null;
//            students = students.stream().map(s->{
//                if(s.getId()==Id){
//                    System.out.println(s.getName());
//                    s.setCity(data.getCity());
//                    s.setName(data.getName());
//                    s.setCourse(data.getCourse());
//                }
//                return s;
//            }).collect(Collectors.toList());
//            student = students.stream().filter(e->e.getId()==Id).findFirst().get();
//            return student;
//
//    }


//    }
        @Autowired
        private StudentRepository student;
            public List<Student> allStudents(){
            List<Student> students = (List<Student>) this.student.findAll();
            return students;
        }

    public Student addStudent(Student s1){
//            students.add(s1);

        Student result = null;
        try{
        result = this.student.save(s1);
            System.out.println("Student added");

        }catch (Exception e){
            e.printStackTrace();
        }
            return result;
        }
    public Optional<Student> findStudentById(int Id){
            Optional<Student> ans = null;
            try{
            ans =  this.student.findById(Id);
            }catch (Exception e){
                e.printStackTrace();
            }
            return ans;
        }

    public List<Student> deleteStudentById(int Id){
//
        try{

        this.student.deleteById(Id);
        }catch (Exception e){
            e.printStackTrace();
        }
//            List<Student> deleted = students.stream().filter(e->e.getId()==Id).collect(Collectors.toList());
//            List<Student> newList = students.stream().filter(e->e.getId()!=Id).collect(Collectors.toList());
//            students = newList;
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        List<Student> result = (List<Student>) this.student.findAll();
            return result;
        }

    public Student updateStudent(Student data,int Id) {

            data.setId(Id);
            this.student.save(data);
            return data;
    }

    }
