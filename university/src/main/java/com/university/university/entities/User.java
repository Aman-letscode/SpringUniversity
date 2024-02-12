package com.university.university.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;

enum Role{
    STUDENT,
    INSTRUCTOR,
    ADMIN
}

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email",unique = true)
    private String emailId;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    public User(int id, String emailId, String password,String role) {
        this.id = id;
        this.emailId = emailId;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role.toString();
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
