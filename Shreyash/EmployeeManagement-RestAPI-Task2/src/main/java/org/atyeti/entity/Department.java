package org.atyeti.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atyeti.entity.auditing.EntityAudit;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department extends EntityAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;

    @Column(nullable = false)
    private String departmentName;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employee;


}
