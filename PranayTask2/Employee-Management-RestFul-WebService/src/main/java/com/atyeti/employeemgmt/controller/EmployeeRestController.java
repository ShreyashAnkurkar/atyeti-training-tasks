package com.atyeti.employeemgmt.controller;

import com.atyeti.employeemgmt.dto.EmployeeRequestDto;
import com.atyeti.employeemgmt.dto.EmployeeResponseDto;
import com.atyeti.employeemgmt.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/employee-api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        EmployeeResponseDto dto = employeeService.addEmployee(employeeRequestDto);
        return new ResponseEntity<>(dto.getEmpId() + " Saved ", HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id){
        EmployeeResponseDto dto = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/save/{prId}")
    public ResponseEntity<EmployeeResponseDto> assignEmployeeToExistingProject(@RequestBody EmployeeRequestDto employeeRequestDto, @PathVariable Long prId){
        return new ResponseEntity<>(employeeService.assignExistingProjectToEmployee(employeeRequestDto,prId), HttpStatus.OK);
    }

    @GetMapping("/findAll-employees")
    public ResponseEntity<List<EmployeeResponseDto>> findAllEmployees(){
        List<EmployeeResponseDto> empDtos = employeeService.findAllEmployees();
        return new ResponseEntity<>(empDtos, HttpStatus.OK);
    }

    @PatchMapping("/update-employee")
    public ResponseEntity<EmployeeResponseDto> updateEmployeeData(@RequestBody EmployeeRequestDto employeeRequestDto){
        EmployeeResponseDto dto = employeeService.updateEmployeeDetails(employeeRequestDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        String res = employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
