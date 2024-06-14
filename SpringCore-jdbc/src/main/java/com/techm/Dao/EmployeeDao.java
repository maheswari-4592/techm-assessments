package com.techm.Dao;


import org.springframework.jdbc.core.JdbcTemplate;
import com.techm.util.EmployeeRowMapper;
import com.techm.model.Employee;

import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (name, department) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        List<Employee> employees = jdbcTemplate.query(sql, new EmployeeRowMapper(), id);
        return employees.isEmpty() ? null : employees.get(0);
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
