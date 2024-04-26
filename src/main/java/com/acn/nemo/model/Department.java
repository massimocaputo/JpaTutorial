package com.acn.nemo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DEPARTMENTS")
@ToString
public class Department implements Serializable {
    private static final long serialVersionUID = 693452596071306403L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENTS_id_gen")
    @SequenceGenerator(name = "DEPARTMENTS_id_gen", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private Short id;

    @Size(max = 30)
    @NotNull
    @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<JobHistory> jobHistories = new LinkedHashSet<>();

}