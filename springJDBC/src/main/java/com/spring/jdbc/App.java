package com.spring.jdbc;

import com.spring.jdbc.dao.Studentdao;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[]args) throws IOException
    {
//        System.out.println("Program Started...");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
          ApplicationContext ctx = new AnnotationConfigApplicationContext(JDBConfig.class);
//        JdbcTemplate jdbctemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        // Insert Querty
//        String insert = "insert into student(id, name, city) values (?, ?, ?)";
//        //Fire Query
//        int result = jdbctemplate.update(insert, 456, "Pranjali", "Aurangabad");

         Studentdao sdao = ctx.getBean("studentDao", Studentdao.class);
//
//        Student student = new Student(666, "John", "New York");
//        int r = sdao.insert(student);
//
//
//        System.out.println("Number of records inserted: "+r);
//        Student  student = new Student(666, "Jay", "Mumbai");
//        sdao.update(student);

//        int r = sdao.delete(666);
//        System.out.println("Records deleted: "+r);

//        Student student = sdao.search(456);
//        System.out.println(student );

        List<Student> students = sdao.display();
        for(Student s: students)
        {
            System.out.println(s);
        }
    }
}
