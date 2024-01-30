package com.university.university;

public class Course {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    private String teacher;

    public Course(long id, String name,String teacher){
        super();
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }
    @Override
    public String toString(){
        return name;
    }
}
