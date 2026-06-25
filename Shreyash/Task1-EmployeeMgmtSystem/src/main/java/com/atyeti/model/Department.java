package com.atyeti.model;

import java.util.Objects;

public class Department {

    private int deptId;
    private String deptName;
    private String managerName;
    private int employeeCount;

    {
        employeeCount++;
    }
    public Department(int deptId, String deptName, String managerName) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.managerName = managerName;

    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptId == that.deptId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(deptId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
