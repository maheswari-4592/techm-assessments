package com.techm.service;



import java.util.List;

import com.techm.Dao.EmployeeDao;
import com.techm.model.Employee;

public class EmployeeManager {
    private EmployeeDao employeeDAO;

    public void setEmployeeDAO(EmployeeDao employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
