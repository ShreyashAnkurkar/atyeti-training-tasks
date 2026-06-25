package com.pranay.dto;

import java.util.Objects;

public class EmployeeDto {
    private Integer empId;
    private String empName;
    private String designation;
    private Double salary;

    public EmployeeDto(){

    }

    public EmployeeDto(Integer empId, String designation, Double salary){
        this.empId = empId;
        this.designation = designation;
        this.salary = salary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeDto that)) return false;
        return Objects.equals(empId, that.empId) && Objects.equals(empName, that.empName) && Objects.equals(designation, that.designation) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, designation, salary);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
