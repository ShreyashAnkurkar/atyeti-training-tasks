package com.atyeti.service.Implementation;

import com.atyeti.EmployeeService;
import com.atyeti.entity.Employee;
import com.atyeti.exception.EmployeeNotFoundException;
import com.atyeti.exception.InvalidInputException;
import com.atyeti.service.Interface.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private static final List<Employee> empData=new ArrayList<>();
    @Override
    public boolean addEmployee(Employee e){
        return empData.add(e);
    }

    @Override
    public boolean updateEmployee(int id, Employee e) {
        Employee emp = searchEmployeeById(id);

        emp.setName(e.getName());
        emp.setAddress(e.getAddress());
        emp.setDept(e.getDept());

        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (id <= 0)
            throw new InvalidInputException("Id must be greater than 0");

        Employee emp = searchEmployeeById(id);

        return empData.remove(emp);
    }

    @Override
    public Employee searchEmployeeById(int id) throws EmployeeNotFoundException {
        if(id<=0)throw new InvalidInputException("Id must be greater than zero");

        return empData.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);    }

    @Override
    public void displayAllEmployees() {
        for(Employee e:empData){
            IO.println(e);
        }
    }
}
