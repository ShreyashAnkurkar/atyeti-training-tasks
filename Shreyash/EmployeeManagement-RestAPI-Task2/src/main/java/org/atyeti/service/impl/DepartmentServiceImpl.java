package org.atyeti.service.impl;

import org.atyeti.dto.request.DepartmentRequest;
import org.atyeti.entity.Department;
import org.atyeti.exception.DepartmentNotFoundException;
import org.atyeti.exception.DuplicateRecordException;
import org.atyeti.exception.InvalidInputException;
import org.atyeti.repository.IDepartmentRepo;
import org.atyeti.service.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private IDepartmentRepo repo;

    public DepartmentServiceImpl(IDepartmentRepo r){this.repo=r;}

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
    public String deleteDepartment(int id) throws InvalidInputException, DepartmentNotFoundException {
        Department d=repo.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Record does not exist in DB"));
        repo.delete(d);
        return "Record Deleted";
    }

    @Override
    public List<Department> getAllDepartment() {
        return repo.findAll();
    }
}
