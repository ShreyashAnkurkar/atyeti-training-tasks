package org.atyeti.dto.request;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atyeti.entity.Department;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "field should not be blank")
    private String empName;
    @NotBlank(message = "Address should not be blank")
    private String address;
    @NotBlank(message = "phoneNo should not blank")
    private Long phoneNo;
    @Email(message = "Invalid Email Formate")
    private String emailId;
    @Column(nullable = false)
    private String deptName;
}
