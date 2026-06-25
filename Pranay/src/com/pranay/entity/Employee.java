package com.pranay.entity;

import com.pranay.exception.InvalidDataException;

import java.util.Objects;

public final class Employee {
    private static int ID_VAL = 100;
    private Integer empId;
    private String empName;
    private String designation;
    private Double salary;

    private boolean validate(String empName, String designation, Double salary){
        if(empName.isBlank()){
            throw new InvalidDataException("Name Should Have at least 1 letter");
        }else if (designation.isBlank()){
            throw new InvalidDataException("Designation Should Have at least 1 letter");
        }else if (salary <= 0){
            throw new InvalidDataException("Salary Should Be Greater Than Zero.");
        }

        return true;
    }

    public Employee(String empName, String designation, Double salary){
        if(validate(empName, designation, salary)) {
            this.empId = ID_VAL++;
            this.empName = empName;
            this.designation = designation;
            this.salary = salary;
        }
    }

    public static int getIdVal() {
        return ID_VAL;
    }

    public static void setIdVal(int idVal) {
        ID_VAL = idVal;
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
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName) && Objects.equals(designation, employee.designation) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, designation, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
