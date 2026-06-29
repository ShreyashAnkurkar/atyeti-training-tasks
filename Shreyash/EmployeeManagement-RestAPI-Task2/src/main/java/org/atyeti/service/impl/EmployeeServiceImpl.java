package org.atyeti.service.impl;

import org.atyeti.dto.request.EmployeeRequest;
import org.atyeti.dto.response.DepartmentResponse;
import org.atyeti.dto.response.EmployeeResponse;
import org.atyeti.entity.Department;
import org.atyeti.entity.Employee;
import org.atyeti.exception.DepartmentNotFoundException;
import org.atyeti.exception.DuplicateRecordException;
import org.atyeti.exception.EmployeeNotFoundException;
import org.atyeti.exception.InvalidInputException;
import org.atyeti.repository.IDepartmentRepo;
import org.atyeti.repository.IEmployeeRepo;
import org.atyeti.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepo repo;
    private final IDepartmentRepo dr;


    EmployeeServiceImpl(IEmployeeRepo e,IDepartmentRepo r){
        this.repo=e;
        this.dr=r;
    }


    @Override
    public String addEmployee(EmployeeRequest e) {
        if(repo.existsByEmailId(e.getEmailId())) throw new DuplicateRecordException("Employee already exists in DB");

        Department dept=dr.findByDepartmentName(e.getDeptName());

        if(dept==null) throw new DepartmentNotFoundException("Department does not exist in db");

       Employee employee=Employee.builder().
                empName(e.getEmpName())
               .address(e.getAddress())
               .emailId(e.getEmailId())
               .phoneNo(e.getPhoneNo())
               .department(dept)
               .build();
        return "Employee added with id"+repo.save(employee).getId();
    }

    @Override
    public String updateEmployee(int id, EmployeeRequest e) throws EmployeeNotFoundException, InvalidInputException {
        Employee employee=repo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Record not exist in DB"));
        Department dept=dr.findByDepartmentName(e.getDeptName());
        if(dept==null) throw new DepartmentNotFoundException("Department does not exist in db");

        employee.setEmpName(e.getEmpName());
        employee.setAddress(e.getAddress());
        employee.setPhoneNo(e.getPhoneNo());
        employee.setEmailId(e.getEmailId());
        employee.setDepartment(dept);

        repo.save(employee);
        return "Employee data updated with id"+id;

    }

    @Override
    public String deleteEmployee(int id) throws InvalidInputException {
        if(id<=0) throw new InvalidInputException("Id must be greater than 0");

        Employee emp=repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not exist in DB"));
        repo.delete(emp);
        return "record deleted with id: "+id;
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> emp = repo.findAll();
        List<EmployeeResponse> list = new ArrayList<>();

        for (Employee e : emp) {
            DepartmentResponse departmentResponse = null;

            if (e.getDepartment() != null) {
                departmentResponse = DepartmentResponse.builder()
                        .dept_id(e.getDepartment().getDeptId())
                        .dept_name(e.getDepartment().getDepartmentName())
                        .build();
            }
            EmployeeResponse res = EmployeeResponse.builder()
                    .id(e.getId())
                    .empName(e.getEmpName())
                    .address(e.getAddress())
                    .phoneNo(e.getPhoneNo())
                    .emailId(e.getEmailId())
                    .department(departmentResponse)
                    .build();
            list.add(res);
        }
        return list;
    }

    @Override
    public EmployeeResponse searchEmpById(int id) throws InvalidInputException, EmployeeNotFoundException {

        if (id <= 0) {
            throw new InvalidInputException("Id must be greater than 0");
        }

        Employee employee = repo.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not exist in DB"));

        DepartmentResponse departmentResponse = null;

        if (employee.getDepartment() != null) {
            departmentResponse = DepartmentResponse.builder()
                    .dept_id(employee.getDepartment().getDeptId())
                    .dept_name(employee.getDepartment().getDepartmentName())
                    .build();
        }

        return EmployeeResponse.builder()
                .id(employee.getId())
                .empName(employee.getEmpName())
                .address(employee.getAddress())
                .phoneNo(employee.getPhoneNo())
                .emailId(employee.getEmailId())
                .department(departmentResponse)
                .build();
    }
}
