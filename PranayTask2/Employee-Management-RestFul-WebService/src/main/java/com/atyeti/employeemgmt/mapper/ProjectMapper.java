package com.atyeti.employeemgmt.mapper;

import com.atyeti.employeemgmt.dto.ProjectRequestDto;
import com.atyeti.employeemgmt.dto.ProjectResponseDto;
import com.atyeti.employeemgmt.entity.Employee;
import com.atyeti.employeemgmt.entity.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectMapper {

    public Project toProjectEntity(ProjectRequestDto dto){
        Project project = new Project();

        if(dto != null){
            project.setProjectName(dto.getProjectName());
            project.setProjectDescription(dto.getProjectDescription());
            project.setBudget(dto.getBudget());

            List<Employee> employeeList = dto.getEmployeeList();
            if(employeeList != null){
                //assign empList to project
                project.setEmployeeList(employeeList);

                //assign project to each and every employee
                employeeList.forEach(emp -> emp.setAssignedProject(project));
            }
        }

        return project;
    }


    public ProjectResponseDto toProjectResponse(Project project){
        return ProjectResponseDto.builder()
                .projectId(project.getProjectId())
                .projectName(project.getProjectDescription())
                .budget(project.getBudget())
                .numberOfEmployees(project.getEmployeeList().size())
                .build();
    }
}
