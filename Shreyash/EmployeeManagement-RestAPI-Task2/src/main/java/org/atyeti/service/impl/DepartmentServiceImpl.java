package org.atyeti.service.impl;

import jakarta.transaction.Transactional;
import org.atyeti.dto.request.DepartmentRequest;
import org.atyeti.entity.Department;
import org.atyeti.entity.Employee;
import org.atyeti.exception.DepartmentNotFoundException;
import org.atyeti.exception.DuplicateRecordException;
import org.atyeti.exception.InvalidInputException;
import org.atyeti.repository.IDepartmentRepo;
import org.atyeti.repository.IEmployeeRepo;
import org.atyeti.service.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private final IDepartmentRepo repo;
    private final IEmployeeRepo er;

    public DepartmentServiceImpl(IDepartmentRepo repo, IEmployeeRepo employeeRepo) {
        this.repo = repo;
        this.er = employeeRepo;
    }

    @Override
    public String addDept(Department d) {

        if(repo.existsByDepartmentName(d.getDepartmentName()))throw new DuplicateRecordException("Record already exists in database");

        return "Department saved with id: "+ repo.save(d).getDeptId();
    }

    @Override
    public Department findByName(String name) {

        Department d=repo.findByDepartmentName(name);
        if(d==null)throw new DepartmentNotFoundException("Department doesnt exist");
        return d;
    }

    @Override
    public String updateDepartment(int id, DepartmentRequest e) throws DepartmentNotFoundException, InvalidInputException {
        Department d=repo.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Department Doesnt exist in database"));
        d.setDepartmentName(e.getDepartmentName());
        return "Department Updated with id: "+repo.save(d).getDeptId();
    }

    @Override
    @Transactional
    public String deleteDepartment(int id) throws InvalidInputException, DepartmentNotFoundException {

        Department department = repo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Record does not exist in DB"));

        List<Employee> employees = department.getEmployee();

        for (Employee employee : employees) {
            employee.setDepartment(null);
        }

        er.saveAll(employees);

        repo.delete(department);

        return "Record Deleted";
    }

    @Override
    public List<Department> getAllDepartment() {
        return repo.findAll();
    }
}
