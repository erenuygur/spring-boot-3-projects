package com.erenuygur.cruddemo.dao;

import com.erenuygur.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
