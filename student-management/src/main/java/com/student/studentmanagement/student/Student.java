package com.student.studentmanagement.student;

import jakarta.validation.constraints.Size;

public class Student {

    private int id;
    private String username;
    private String studentname;
    private String standard;

    public Student(int id, String username, String studentname, String standard) {
        super();
        this.id = id;
        this.username = username;
        this.studentname = studentname;
        this.standard = standard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", studentname='" + studentname + '\'' +
                ", standard='" + standard + '\'' +
                '}';
    }
}
