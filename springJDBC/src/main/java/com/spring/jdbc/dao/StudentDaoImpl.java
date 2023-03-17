package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements  Studentdao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id, name, city) values (?, ?, ?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }

    @Override
    public void update(Student student) {
        String query = "update student set name = ?, city= ?  where id = ?";
        this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
    }

    @Override
    public int delete(int id) {
        String query = "Delete from student where id = ?";
        int r = jdbcTemplate.update(query, id);
        return r;
    }

    @Override
    public Student search(int id) {
        String search = "select * from student where id = ?";
        RowMapper<Student>rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(search, rowMapper, id);
        return student;
    }

    @Override
    public List<Student> display() {
        String display = "Select * from Student";
        List<Student> students = this.jdbcTemplate.query(display,new RowMapperImpl());
        return students;
    }
}
