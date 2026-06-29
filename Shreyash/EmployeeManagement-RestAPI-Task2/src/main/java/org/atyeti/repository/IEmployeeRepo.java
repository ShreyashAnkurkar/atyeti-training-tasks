package org.atyeti.repository;

import org.atyeti.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
    boolean existsByEmailId(String emailId);

}
