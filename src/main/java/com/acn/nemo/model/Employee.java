package com.acn.nemo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMPLOYEES")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT  e from Employee e "),
        @NamedQuery(name = "Employee.findByIdEquals", query = "select e from Employee e where e.id = :id"),
        @NamedQuery(name = "Employee.findByLastNameStartsWith", query = "select e from Employee e where e.lastName like concat(:lastName, '%')"),
        @NamedQuery(name = "Employee.findByFirstNameStartsWithIgnoreCaseAndLastNameStartsWithIgnoreCase", query = "select e from Employee e where upper(e.firstName) like upper(concat(:firstName, '%')) and upper(e.lastName) like upper(concat(:lastName, '%'))"),
        @NamedQuery(name = "Employee.findBySalaryGreaterThanEqualAndJob_JobIdEqualsIgnoreCase", query = "select e from Employee e where e.salary >= :salary and upper(e.job.jobId) = upper(:jobId)"),
        @NamedQuery(name = "Employee.findByManager_IdNull", query = "select e from Employee e where e.manager.id is null"),
        @NamedQuery(name = "Employee.findByDepartment_IdEquals", query = "select e from Employee e where e.department.id = :id")
})
public class Employee implements Serializable {
    private static final long serialVersionUID = -7883799433391138533L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_id_gen")
    @SequenceGenerator(name = "EMPLOYEES_id_gen", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
    @Column(name = "EMPLOYEE_ID", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;

    @Size(max = 25)
    @NotNull
    @Column(name = "LAST_NAME", nullable = false, length = 25)
    private String lastName;

    @Size(max = 25)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 25)
    private String email;

    @Size(max = 20)
    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @NotNull
    @Column(name = "HIRE_DATE", nullable = false)
    private LocalDate hireDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "JOB_ID", nullable = false)
    private Job job;

    @Column(name = "SALARY", precision = 8, scale = 2)
    private BigDecimal salary;

    @Column(name = "COMMISSION_PCT", precision = 2, scale = 2)
    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @OneToMany(mappedBy = "manager")
    private Set<Department> departments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "manager")
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<JobHistory> jobHistories = new LinkedHashSet<>();

}