package com.atyeti.employeemgmt.dto;

import com.atyeti.employeemgmt.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequestDto {
    private Long empId;
    private String empName;
    private Double salary;

    //project data
    private Project assignedProject;
}
