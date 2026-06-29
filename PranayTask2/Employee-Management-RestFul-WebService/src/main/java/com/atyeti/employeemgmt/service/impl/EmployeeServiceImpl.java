package com.atyeti.employeemgmt.service.impl;

import com.atyeti.employeemgmt.dto.EmployeeRequestDto;
import com.atyeti.employeemgmt.dto.EmployeeResponseDto;
import com.atyeti.employeemgmt.entity.Employee;
import com.atyeti.employeemgmt.entity.Project;
import com.atyeti.employeemgmt.exception.EmployeeNotFoundException;
import com.atyeti.employeemgmt.exception.ProjectNotFoundException;
import com.atyeti.employeemgmt.mapper.EmployeeMapper;
import com.atyeti.employeemgmt.repository.EmployeeRepository;
import com.atyeti.employeemgmt.repository.ProjectRepository;
import com.atyeti.employeemgmt.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeMapper.toEntity(employeeRequestDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toResponse(savedEmployee);
    }

    @Override
    public EmployeeResponseDto findEmployeeById(Long id) {
        Employee employee = findEmployee(id);

        return employeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponseDto assignExistingProjectToEmployee(EmployeeRequestDto employeeRequestDto, Long prId) {
        Project project = projectRepository.findById(prId).orElseThrow(() -> new ProjectNotFoundException("Project NOT FOUND! "+prId));

        Employee employee = employeeMapper.toEntity(employeeRequestDto);
        employee.setAssignedProject(project);

        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toResponse(savedEmployee);
    }

    @Override
    public EmployeeResponseDto updateEmployeeDetails(EmployeeRequestDto requestDto) {
        Employee employee = findEmployee(requestDto.getEmpId());

        BeanUtils.copyProperties(requestDto, employee);
        Employee updatedEmployee = employeeRepository.save(employee);

        return employeeMapper.toResponse(updatedEmployee);
    }

    @Override
    public String deleteEmployeeById(Long id) {
        Employee employee = findEmployee(id);
        employee.setAssignedProject(null);
        employeeRepository.delete(employee);
        return "Employee Data Deleted Successfully : "+id;
    }

    @Override
    public List<EmployeeResponseDto> findAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    private Employee findEmployee(Long empId){
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee NOT FOUND! : "+empId));
    }
}
