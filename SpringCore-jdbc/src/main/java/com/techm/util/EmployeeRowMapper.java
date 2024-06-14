package com.techm.util;


import org.springframework.jdbc.core.RowMapper;

import com.techm.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee>
{
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setDepartment(resultSet.getString("department"));
        return employee;
    }
}
