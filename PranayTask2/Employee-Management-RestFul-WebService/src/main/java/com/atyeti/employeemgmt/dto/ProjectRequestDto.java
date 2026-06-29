package com.atyeti.employeemgmt.dto;

import com.atyeti.employeemgmt.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private Double budget;

    List<Employee> employeeList;
}
