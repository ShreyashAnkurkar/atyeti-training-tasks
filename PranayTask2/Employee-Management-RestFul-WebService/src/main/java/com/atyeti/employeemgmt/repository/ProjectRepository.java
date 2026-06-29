package com.atyeti.employeemgmt.repository;

import com.atyeti.employeemgmt.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
