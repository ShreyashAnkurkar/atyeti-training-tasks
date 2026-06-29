package org.atyeti.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.atyeti.entity.auditing.EntityAudit;

@Data
@Entity
@Table(name = "EMPLOYEES_DATA")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends EntityAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String empName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false,unique = true)
    private Long phoneNo;


    @Email( message ="Invalid Email Formate")
    @Column(nullable = false,unique = true)
    private String emailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId")
    private Department department;


}
