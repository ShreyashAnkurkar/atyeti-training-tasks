package org.atyeti.controller;

import org.atyeti.dto.request.DepartmentRequest;
import org.atyeti.dto.response.DepartmentResponse;
import org.atyeti.entity.Department;
import org.atyeti.service.IDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dept-api")
public class DepartmentController {

    private final IDepartmentService ds;

    public DepartmentController(IDepartmentService d) {
        this.ds = d;
    }

    @PostMapping("/createDept")
    public ResponseEntity<String> createDept(@RequestBody DepartmentRequest dr) {

        Department d = Department.builder()
                .departmentName(dr.getDepartmentName())
                .build();

        return new ResponseEntity<>(ds.addDept(d), HttpStatus.CREATED);
    }

    @PutMapping("/updateDept/{id}")
    public ResponseEntity<String> updateDept(@PathVariable int id,
                                             @RequestBody DepartmentRequest dr) {

        return new ResponseEntity<>(ds.updateDepartment(id, dr), HttpStatus.OK);
    }

    @DeleteMapping("/deleteDept/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable int id) {

        return new ResponseEntity<>(ds.deleteDepartment(id), HttpStatus.OK);
    }

    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<DepartmentResponse>> getAllDept() {

        List<Department> d = ds.getAllDepartment();
        List<DepartmentResponse> res = new ArrayList<>();

        for (Department dept : d) {
            DepartmentResponse dr = DepartmentResponse.builder()
                    .dept_id(dept.getDeptId())
                    .dept_name(dept.getDepartmentName())
                    .build();
            res.add(dr);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}