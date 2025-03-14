package com.spring.SpringBoot2.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.SpringBoot2.entity.Employee;
import com.spring.SpringBoot2.mapper.EmployeeRowMapper;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Employee emp) {
        return jdbcTemplate.update("INSERT INTO employees1 (id, first_Name, last_Name, email, password) VALUES (?, ?, ?, ?, ?)",
                emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getPassword());
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees1 WHERE id = ?", new EmployeeRowMapper(), id);
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees1", new EmployeeRowMapper());
    }

    public int update(Employee emp) {
        return jdbcTemplate.update("UPDATE employees1 SET first_Name=?, last_Name=?, email=?, password=? WHERE id=?",
                emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getId(), emp.getPassword());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM employees1 WHERE id = ?", id);
    }
}
