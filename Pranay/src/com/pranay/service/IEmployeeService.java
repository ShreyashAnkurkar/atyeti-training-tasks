package com.pranay.service;

import com.pranay.dto.EmployeeDto;
import com.pranay.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService{
    String addEmployee(Employee emp);
    String updateEmployee(EmployeeDto emp);
    String deleteEmployee(Integer empId);
    Optional<Employee> searchEmployeeById(Integer empId);
    List<Employee> displayAllEmployees();
}
