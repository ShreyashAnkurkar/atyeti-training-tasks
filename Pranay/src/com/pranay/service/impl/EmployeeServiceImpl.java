package com.pranay.service.impl;

import com.pranay.dto.EmployeeDto;
import com.pranay.entity.Employee;
import com.pranay.exception.EmployeeNotFoundException;
import com.pranay.service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements IEmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public String addEmployee(Employee employee) {
        employeeList.add(employee);
        return "New Employee Data Added with Id value : "+employee.getEmpId();
    }

    private void helper(Employee emp, EmployeeDto employeeDto){
        emp.setDesignation(employeeDto.getDesignation());
        emp.setSalary(employeeDto.getSalary());
    }

    @Override
    public String updateEmployee(EmployeeDto employeeDto) {
        boolean flag = false;
        Integer empId = employeeDto.getEmpId();

        for(int i = 0; i < employeeList.size(); i++){
            Employee employee = employeeList.get(i);
            if(employee.getEmpId().equals(empId)){
                helper(employee, employeeDto);
                employeeList.set(i, employee);
                flag = true;
            }
        }


        if(flag){
            return "Employee Having id : "+empId+" Updated Successfully";
        }

        throw new EmployeeNotFoundException(empId + " Employee NOT FOUND!");
    }

    @Override
    public String deleteEmployee(Integer id) {
        StringBuilder msg = new StringBuilder();

        for(Employee emp : employeeList){
            if(emp.getEmpId().equals(id)){
                employeeList.remove(emp);
                return "Employee With Id : "+emp.getEmpId()+" Deleted Successfully.";
            }
        }

        throw new EmployeeNotFoundException(id + " Employee NOT FOUND!");
    }

    @Override
    public Optional<Employee> searchEmployeeById(Integer empId) {
        Optional<Employee> first = employeeList.stream()
                .filter(emp -> emp.getEmpId().equals(empId))
                .findFirst();

        if(first.isPresent()){
            return first;
        }

        throw new EmployeeNotFoundException(empId + " Employee NOT FOUND!");
    }

    @Override
    public List<Employee> displayAllEmployees() {
        return employeeList;
    }
}
