package com.atyeti.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @SequenceGenerator(name = "gen1", sequenceName = "EMP_SEQ1", initialValue = 100, allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    @Id
    private Long empId;
    private String empName;
    private Double salary;

    //association properties
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId" , referencedColumnName = "projectId")
    private Project assignedProject;

    //metadata properties
    @Version
    private Integer updateCount = 0;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedOn;

    //active switch (for Soft Deletion)
    private String active = "Active";
}
