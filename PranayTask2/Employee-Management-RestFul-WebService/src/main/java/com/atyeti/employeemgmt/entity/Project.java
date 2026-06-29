package com.atyeti.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @SequenceGenerator(name = "gen1", sequenceName = "PR_SEQ1", initialValue = 200, allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    @Id
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private Double budget;

    @OneToMany(mappedBy = "assignedProject", fetch = FetchType.LAZY)
    private List<Employee> employeeList = new ArrayList<>();
}
