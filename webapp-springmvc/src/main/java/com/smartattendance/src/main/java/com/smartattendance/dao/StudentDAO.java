package com.smartattendance.dao;

import java.util.List;
import com.smartattendance.model.Student;

public interface StudentDAO {
    void save(Student s);
    List<Student> findAll();
}
