package com.erenuygur.cruddemo.dao;

import com.erenuygur.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);
}
