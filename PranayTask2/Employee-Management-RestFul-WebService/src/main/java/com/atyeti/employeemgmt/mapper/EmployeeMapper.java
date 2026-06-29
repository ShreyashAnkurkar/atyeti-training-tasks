package com.atyeti.employeemgmt.mapper;

import com.atyeti.employeemgmt.dto.EmployeeRequestDto;
import com.atyeti.employeemgmt.dto.EmployeeResponseDto;
import com.atyeti.employeemgmt.entity.Employee;
import com.atyeti.employeemgmt.entity.Project;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EmployeeMapper {
   public Employee toEntity(EmployeeRequestDto empDto){
       Employee employee = new Employee();
       employee.setEmpName(empDto.getEmpName());
       employee.setSalary(empDto.getSalary());

       if(empDto.getAssignedProject() != null){
           Project project = new Project();
           project.setProjectName(empDto.getAssignedProject().getProjectName());
           project.setProjectDescription(empDto.getAssignedProject().getProjectDescription());
           project.setBudget(empDto.getAssignedProject().getBudget());

           project.setEmployeeList(Arrays.asList(employee));

           employee.setAssignedProject(project);
       }

       return employee;
   }

    public EmployeeResponseDto toResponse(Employee employee) {

        Project project = employee.getAssignedProject();

        return EmployeeResponseDto.builder()
                .empId(employee.getEmpId())
                .empName(employee.getEmpName())
                .empSalary(employee.getSalary())
                .projectId(project.getProjectId())
                .projectDescription(project.getProjectDescription())
                .budget(project.getBudget())
                .build();
    }
}
