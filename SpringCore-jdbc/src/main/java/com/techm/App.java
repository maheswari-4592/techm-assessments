package com.techm;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techm.model.Employee;
import com.techm.service.EmployeeManager;

import java.util.List;

public class App {
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeManager employeeManager = (EmployeeManager) context.getBean("employeeManager");

       
        //  Add employee
        Employee e1 = new Employee(1, "Maheswari", "HR");
        Employee e2 = new Employee(2, "teja", "manager");
        Employee e3 = new Employee(3, "pooja", "developer");
        Employee e4 = new Employee(4, "karthi", "tester");

        employeeManager.addEmployee(e1);
        employeeManager.addEmployee(e2);
        employeeManager.addEmployee(e3);
        employeeManager.addEmployee(e4);


        //  Get all employees
        List<Employee> employees = employeeManager.getAllEmployees();
        System.out.println("All Employees:");
        for (Employee emp : employees) {
            System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getDepartment());
        }

        //  Get employee by ID
        Employee empById = employeeManager.getEmployeeById(2);
        System.out.println("Employee with ID 1: " + empById.getName());

        //  Update employee
        empById.setDepartment("Finance");
        employeeManager.updateEmployee(empById);

        //  Delete employee
        employeeManager.deleteEmployee(3);

        context.close();
    }
}
