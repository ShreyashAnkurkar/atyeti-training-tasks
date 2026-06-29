package com.atyeti.service.Interface;

import com.atyeti.entity.Employee;
import com.atyeti.exception.EmployeeNotFoundException;
import com.atyeti.exception.InvalidInputException;

import java.util.List;

public interface IEmployeeService {

    public boolean addEmployee(Employee e);

    public boolean updateEmployee(int id,Employee e) throws InvalidInputException, EmployeeNotFoundException;

    public boolean deleteEmployee(int id) throws InvalidInputException, EmployeeNotFoundException;

    public Employee searchEmployeeById(int id) throws EmployeeNotFoundException;

    public void displayAllEmployees();

}
