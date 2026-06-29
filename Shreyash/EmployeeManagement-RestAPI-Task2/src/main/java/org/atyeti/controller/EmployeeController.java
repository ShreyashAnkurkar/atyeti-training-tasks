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

        return new ResponseEntity<>(es.addEmployee(er), HttpStatus.CREATED);
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
        return new ResponseEntity<>(es.getAllEmployees(), HttpStatus.OK);

    }

    @GetMapping("/searchEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(es.searchEmpById(id), HttpStatus.OK);
    }
}