package org.atyeti.dto.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.atyeti.entity.Department;

@Data
@Builder
public class EmployeeResponse {
    private Integer id;
    private String empName;
    private String address;
    private Long phoneNo;
    private String emailId;
    private String deptName;
    private DepartmentResponse department;
}
