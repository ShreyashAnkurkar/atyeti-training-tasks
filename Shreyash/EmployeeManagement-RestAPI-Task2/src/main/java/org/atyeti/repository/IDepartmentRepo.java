package org.atyeti.repository;

import org.atyeti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepo extends JpaRepository<Department, Integer> {

    Department findByDepartmentName(String name);

    boolean existsByDepartmentName(String name);
}