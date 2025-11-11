package com.smartattendance.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int student_id;
    private String name;
    private String roll_no;
    private String course;
    private String semester;

    // getters/setters
    public int getStudent_id(){ return student_id; }
    public void setStudent_id(int id){ this.student_id=id; }
    public String getName(){ return name; }
    public void setName(String n){ this.name=n; }
    public String getRoll_no(){ return roll_no; }
    public void setRoll_no(String r){ this.roll_no=r; }
    public String getCourse(){ return course; }
    public void setCourse(String c){ this.course=c; }
    public String getSemester(){ return semester; }
    public void setSemester(String s){ this.semester=s; }
}
