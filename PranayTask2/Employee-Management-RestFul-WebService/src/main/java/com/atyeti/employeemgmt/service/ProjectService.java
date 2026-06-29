package com.atyeti.employeemgmt.service;

import com.atyeti.employeemgmt.dto.ProjectRequestDto;
import com.atyeti.employeemgmt.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {
    ProjectResponseDto addProjectWithEmployees(ProjectRequestDto projectRequestDto);

    ProjectResponseDto findProjectById(Long prId);

    ProjectResponseDto updateProject(ProjectRequestDto dto);

    String deleteProjectById(Long prId);

    List<ProjectResponseDto> findAllProjects();

}
