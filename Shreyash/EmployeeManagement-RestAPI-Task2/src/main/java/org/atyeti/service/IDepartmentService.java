package org.atyeti.service;

import org.atyeti.dto.request.DepartmentRequest;
import org.atyeti.entity.Department;
import org.atyeti.exception.DepartmentNotFoundException;
import org.atyeti.exception.InvalidInputException;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    public String addDept(Department d);

    public Department findByName(String name);

    public String updateDepartment(int id, DepartmentRequest e)throws DepartmentNotFoundException, InvalidInputException;

    public String deleteDepartment(int id)throws InvalidInputException,DepartmentNotFoundException;

    public List<Department> getAllDepartment();


}
