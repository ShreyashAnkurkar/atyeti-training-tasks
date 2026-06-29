package com.atyeti.employeemgmt.service;

import com.atyeti.employeemgmt.dto.EmployeeRequestDto;
import com.atyeti.employeemgmt.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto findEmployeeById(Long id);

    EmployeeResponseDto assignExistingProjectToEmployee(EmployeeRequestDto employeeRequestDto, Long prId);

    EmployeeResponseDto updateEmployeeDetails(EmployeeRequestDto requestDto);

    String deleteEmployeeById(Long id);

    List<EmployeeResponseDto> findAllEmployees();
}
