package com.atyeti.employeemgmt.service.impl;

import com.atyeti.employeemgmt.dto.ProjectRequestDto;
import com.atyeti.employeemgmt.dto.ProjectResponseDto;
import com.atyeti.employeemgmt.entity.Employee;
import com.atyeti.employeemgmt.entity.Project;
import com.atyeti.employeemgmt.exception.ProjectNotFoundException;
import com.atyeti.employeemgmt.mapper.ProjectMapper;
import com.atyeti.employeemgmt.repository.EmployeeRepository;
import com.atyeti.employeemgmt.repository.ProjectRepository;
import com.atyeti.employeemgmt.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponseDto addProjectWithEmployees(ProjectRequestDto projectRequestDto) {
        Project project = projectMapper.toProjectEntity(projectRequestDto);

        Project savedProject = projectRepository.save(project);
        return projectMapper.toProjectResponse(savedProject);
    }

    @Override
    public ProjectResponseDto findProjectById(Long prId) {

        Project project = findProject(prId);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponseDto updateProject(ProjectRequestDto dto){
        Project project = findProject(dto.getProjectId());

        String projectName = dto.getProjectName();
        String description = dto.getProjectDescription();
        Double budget = dto.getBudget();
        List<Employee> employeeList = dto.getEmployeeList();

        if(projectName != null){
            project.setProjectName(projectName);
        }

        if(description != null){
            project.setProjectDescription(description);
        }

        if(budget != null){
            project.setBudget(budget);
        }

        if(employeeList != null){
            dto.getEmployeeList().forEach(emp -> {
                project.getEmployeeList().add(emp);
                emp.setAssignedProject(project);
            });
        }

        Project newProject = projectRepository.save(project);

        return projectMapper.toProjectResponse(newProject);
    }

    @Override
    public String deleteProjectById(Long prId) {
        Project project = findProject(prId);

        List<Employee> employeeList = project.getEmployeeList();
        employeeList.forEach(emp -> {
            emp.setAssignedProject(null);
            employeeRepository.save(emp);
        });

        project.setEmployeeList(null);

        projectRepository.delete(project);

        return "Project Deleted Successfully! : "+prId;
    }

    @Override
    public List<ProjectResponseDto> findAllProjects() {

        return projectRepository.findAll().stream()
                .map(projectMapper::toProjectResponse)
                .toList();
    }

    private Project findProject(Long prId){
        return projectRepository.findById(prId)
                .orElseThrow(() -> new ProjectNotFoundException("Project NOT FOUND! : "+prId));
    }
}
