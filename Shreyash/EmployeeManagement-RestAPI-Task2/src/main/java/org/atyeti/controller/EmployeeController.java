package org.atyeti.controller;

import org.atyeti.dto.request.EmployeeRequest;
import org.atyeti.dto.response.DepartmentResponse;
import org.atyeti.dto.response.EmployeeResponse;
import org.atyeti.entity.Employee;
import org.atyeti.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employee-api")
public class EmployeeController {

    private final IEmployeeService es;

    public EmployeeController(IEmployeeService es) {
        this.es = es;
    }

    @PostMapping("insertEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest er) {

        Employee employee = Employee.builder()
                .empName(er.getEmpName())
                .address(er.getAddress())
                .deptName(er.getDeptName())
                .emailId(er.getEmailId())
                .phoneNo(er.getPhoneNo())
                .build();

        return new ResponseEntity<>(es.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/modifyEmployee/{id}")
    public ResponseEntity<String> modifyEmployee(@PathVariable int id,
                                                 @RequestBody EmployeeRequest er) {

        return new ResponseEntity<>(es.updateEmployee(id, er), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        return new ResponseEntity<>(es.deleteEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/getallEmployee")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {

        List<Employee> emp = es.getAllEmployees();
        List<EmployeeResponse> list = new ArrayList<>();

        for (Employee e : emp) {
            EmployeeResponse res = EmployeeResponse.builder()
                    .id(e.getId())
                    .empName(e.getEmpName())
                    .address(e.getAddress())
                    .phoneNo(e.getPhoneNo())
                    .emailId(e.getEmailId())
                    .deptName(e.getDeptName())
                    .department(
                            DepartmentResponse.builder()
                                    .dept_id(e.getDepartment().getDeptId())
                                    .dept_name(e.getDepartment().getDepartmentName())
                                    .build()
                    )
                    .build();

            list.add(res);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/searchEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {

        Employee e = es.searchEmpById(id);

        EmployeeResponse res = EmployeeResponse.builder()
                .id(e.getId())
                .empName(e.getEmpName())
                .address(e.getAddress())
                .phoneNo(e.getPhoneNo())
                .emailId(e.getEmailId())
                .deptName(e.getDeptName())
                .department(
                        DepartmentResponse.builder()
                                .dept_id(e.getDepartment().getDeptId())
                                .dept_name(e.getDepartment().getDepartmentName())
                                .build()
                )
                .build();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}