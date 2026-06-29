package com.atyeti.employeemgmt.controller;

import com.atyeti.employeemgmt.dto.ProjectRequestDto;
import com.atyeti.employeemgmt.dto.ProjectResponseDto;
import com.atyeti.employeemgmt.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-api")
@RequiredArgsConstructor
public class ProjectRestController {
    private final ProjectService projectService;

    @PostMapping("/save-project")
    public ResponseEntity<String> addProjectWithTheirEmployees(@RequestBody ProjectRequestDto projectRequestDto){

        ProjectResponseDto projectResponseDto = projectService.addProjectWithEmployees(projectRequestDto);

        return new ResponseEntity<>("Project saved With ID : "+projectResponseDto.getProjectId(), HttpStatus.OK);
    }

    @GetMapping("/findProject/{prId}")
    public ResponseEntity<ProjectResponseDto> findProjectById(@PathVariable Long prId){

        ProjectResponseDto dto = projectService.findProjectById(prId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PatchMapping("/update-project")
    public ResponseEntity<ProjectResponseDto> updateProject(@RequestBody ProjectRequestDto requestDto){

        ProjectResponseDto dto = projectService.updateProject(requestDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/delete-project/{prId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long prId){

        String res = projectService.deleteProjectById(prId);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/findAll-projects")
    public ResponseEntity<List<ProjectResponseDto>> findAllProjects(){
        return new ResponseEntity<>(projectService.findAllProjects(), HttpStatus.OK);
    }
}
