package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

public interface Studentdao {
    public int insert(Student student);

    public void update(Student student);

    public int delete(int id);

    public Student search(int id);

    public List<Student> display();
}
