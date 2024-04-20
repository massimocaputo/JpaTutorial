package com.acn.nemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "Employee.findAll", query = "SELECT e from Employee e" )
        }
)
public class Employee implements Serializable{


    private static final long serialVersionUID = -1297088571819376458L;

    @Id
    @Column(name="EMPLOYEE_ID", length = 6, nullable = false)
    private Integer employeeId;

    @Column(name = "FIRST_NAME", length = 20, nullable = true)
    private String firstName;

    @Column(name = "LAST_NAME", length = 25, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 25, unique = true, nullable = false)
    private String email;

    @Column(name = "JOB_ID", length = 10, nullable = false)
    private String jobId;

    @Column(name = "SALARY", length = 8, precision = 2)
    private Long phoneNumber;

    @Column(name = "COMMISSION_PCT", length = 2, precision = 2)
    private Long commissionPct;

    @Column(name = "MANAGER_ID", length = 6, precision = 0)
    private Long managerId;

    @Column(name = "DEPARTMENT_ID", length = 4)
    private Long departmentId;

    //HIRE_DATE	DATE	No

}
