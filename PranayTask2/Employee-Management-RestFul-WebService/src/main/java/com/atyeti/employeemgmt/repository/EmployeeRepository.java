package com.atyeti.employeemgmt.repository;

import com.atyeti.employeemgmt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
