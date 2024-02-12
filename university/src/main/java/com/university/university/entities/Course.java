package com.university.university.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "coursecode")
    private String courseCode;

    @Column(name = "coursename")
    private String courseName;

    @Column(name="duration")
    private int duration;
    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "user_course",fetch = FetchType.LAZY)
    private Set<User> usersEnrolled;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + Id +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }
}
