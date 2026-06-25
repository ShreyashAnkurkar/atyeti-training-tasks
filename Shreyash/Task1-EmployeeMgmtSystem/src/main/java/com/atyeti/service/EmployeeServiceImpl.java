package com.atyeti.service;

import com.atyeti.model.Employee;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EmployeeServiceImpl implements IEmployeeService{

    private  final List<Employee> empData=new ArrayList<>();
    @Override
    public boolean addEmployee(Employee e) {
        return empData.add(e);
    }

    @Override
    public boolean updateEmployee(int id,Employee e) {
        if(searchEmployeeById(id)==null) return false;

        Employee emp=searchEmployeeById(id);
        emp.setName(e.getName());
        emp.setAddress(e.getAddress());
        emp.setDept(e.getDept());

        return true;

    }

    @Override
    public boolean deleteEmployee(int id) {
        Employee e=searchEmployeeById(id);
        return empData.remove(e);
    }

    @Override
    public Employee searchEmployeeById(int id) {
        return empData.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Employee> displayAllEmployees() {
        return empData;
    }
}
