//package com.university.university.entities;
//
//
//import jakarta.persistence.*;
//
//import java.util.Set;
//
//@Entity
//@Table(name="DETAILS")
//public class UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long Id;
//
//    @OneToOne
//    @JoinColumn(name="user_id")
//    private User user;
//
//
//    @Column(name = "firstname")
//    private String firstname;
//    @Column(name = "lastname")
//    private String lastname;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "phonenumber")
//    private String phoneNumber;
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Column(name="selectedcourses")
//    @JoinTable(name="user_course",
//    joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
//    Set<Course> selectedCourses;
//
//
//
//    public UserDetails(){
//        super();
//    }
//    public long getId() {
//        return Id;
//    }
//
//    public void setId(long id) {
//        Id = id;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//}
