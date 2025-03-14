package com.spring.SpringBoot2.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.SpringBoot2.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setFirstName(rs.getString("first_Name"));
        emp.setLastName(rs.getString("last_Name"));
        emp.setEmail(rs.getString("email"));
        emp.setPassword(rs.getString("password"));

        return emp;
    }
}
