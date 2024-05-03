package com.acn.nemo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Employee.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMPLOYEES", uniqueConstraints = {
        @UniqueConstraint(name = "EMP_EMAIL_UK", columnNames = {"EMAIL"})
})

@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT  e from Employee e "),
        @NamedQuery(name = "Employee.findByIdEquals", query = "select e from Employee e where e.id = :id"),
        @NamedQuery(name = "Employee.findByLastNameStartsWith", query = "select e from Employee e where e.lastName like concat(:lastName, '%')"),
        @NamedQuery(name = "Employee.findByFirstNameStartsWithIgnoreCaseAndLastNameStartsWithIgnoreCase", query = "select e from Employee e where upper(e.firstName) like upper(concat(:firstName, '%')) and upper(e.lastName) like upper(concat(:lastName, '%'))"),
        @NamedQuery(name = "Employee.findBySalaryGreaterThanEqualAndJob_JobIdEqualsIgnoreCase", query = "select e from Employee e where e.salary >= :salary and upper(e.job.jobId) = upper(:jobId)"),
        @NamedQuery(name = "Employee.findByManager_IdNull", query = "select e from Employee e where e.manager.id is null"),
        @NamedQuery(name = "Employee.findByDepartment_IdEquals", query = "select e from Employee e where e.department.id = :id"),
        @NamedQuery(name = "Employee.findByJob_JobIdEqualsAndManager_IdNotNull", query = "select e from Employee e where e.job.jobId = :jobId and e.manager.id is not null")
})
public class Employee implements Serializable {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -7883799433391138533L;
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_id_gen")
    @SequenceGenerator(name = "EMPLOYEES_id_gen", sequenceName = "EMPLOYEES_SEQ", allocationSize = 0)
    @Column(name = "EMPLOYEE_ID", nullable = false)
    private Integer id;

    /**
     * The First name.
     */
    @Size(max = 20)
    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;

    /**
     * The Last name.
     */
    @Size(max = 25)
    @NotNull
    @Column(name = "LAST_NAME", nullable = false, length = 25)
    private String lastName;

    /**
     * The Email.
     */
    @Size(max = 25)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 25)
    private String email;

    /**
     * The Phone number.
     */
    @Size(max = 20)
    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    /**
     * The Hire date.
     */
    @NotNull
    @Column(name = "HIRE_DATE", nullable = false)
    private LocalDate hireDate;

    /**
     * The Job.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "JOB_ID", nullable = false)
    private Job job;

    /**
     * The Salary.
     */
    @Column(name = "SALARY", precision = 8, scale = 2)
    private BigDecimal salary;

    /**
     * The Commission pct.
     */
    @Column(name = "COMMISSION_PCT", precision = 2, scale = 2)
    private BigDecimal commissionPct;

    /**
     * The Manager.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    /**
     * The Department.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    /**
     * The Job histories.
     */
    @OneToMany //(mappedBy = "employee")
    private List<JobHistory> jobHistories = new ArrayList<>();

}