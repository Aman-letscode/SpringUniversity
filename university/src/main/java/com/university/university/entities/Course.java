package com.university.university.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany(mappedBy = "selectedCourses",fetch = FetchType.LAZY)
    private Set<User> usersEnrolled;

    @CreationTimestamp(source = SourceType.DB)
    private LocalDateTime createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    private LocalDateTime updatedAt;

    public Course(String courseCode, String courseName, int duration, String description) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.duration = duration;
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
                ", usersEnrolled=" + usersEnrolled +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
