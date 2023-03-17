package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.dao.Studentdao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.dao")
public class JDBConfig {

    @Bean(name= {"dataSource"})
    public DataSource getdataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");

        return dataSource;
    }

    @Bean(name = {"jdbcTemplate"})
    public JdbcTemplate getjdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getdataSource());

        return jdbcTemplate;
    }

}
