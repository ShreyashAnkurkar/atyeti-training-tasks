package com.atyeti.service;

import com.atyeti.model.Employee;

import java.util.List;

public interface IEmployeeService {

    public boolean addEmployee(Employee e);

    public boolean updateEmployee(int id,Employee e);

    public boolean deleteEmployee(int id);

    public Employee searchEmployeeById(int id);

    public List<Employee> displayAllEmployees();

}
