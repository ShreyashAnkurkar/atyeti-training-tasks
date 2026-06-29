package com.atyeti.employeemgmt.dto;

import com.atyeti.employeemgmt.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private Long empId;
    private String empName;
    private Double empSalary;
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private Double budget;
}
