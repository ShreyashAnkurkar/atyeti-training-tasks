package org.atyeti.service;

import org.atyeti.dto.request.EmployeeRequest;
import org.atyeti.dto.response.EmployeeResponse;
import org.atyeti.entity.Employee;
import org.atyeti.exception.EmployeeNotFoundException;
import org.atyeti.exception.InvalidInputException;

import java.util.List;

public interface IEmployeeService {

    public String addEmployee(Employee e);

    public String updateEmployee(int id,EmployeeRequest e)throws EmployeeNotFoundException, InvalidInputException;

    public String deleteEmployee(int id)throws InvalidInputException;

    public List<Employee> getAllEmployees();

    public Employee searchEmpById(int id)throws InvalidInputException,EmployeeNotFoundException;
}
