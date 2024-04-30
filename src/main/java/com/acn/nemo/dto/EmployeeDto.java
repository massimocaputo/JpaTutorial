package com.acn.nemo.dto;

import com.acn.nemo.model.Employee;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Employee dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmployeeDto implements Serializable {
    /**
     * The constant serialVersionUID.
     */
    private static  long serialVersionUID = -8785253320801705699L;
    /**
     * The Id.
     */
    private  Integer id;
    /**
     * The First name.
     */
    @Size(max = 20)
    private  String firstName;
    /**
     * The Last name.
     */
    @NotNull
    @Size(max = 25)
    private  String lastName;
    /**
     * The Email.
     */
    @NotNull
    @Size(max = 25)
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
    private  String email;
    /**
     * The Phone number.
     */
    @Size(max = 20)
    private  String phoneNumber;
    /**
     * The Hire date.
     */
    @NotNull
    private  LocalDate hireDate;
    /**
     * The Job.
     */
    @NotNull
    private  JobDto job;
    /**
     * The Salary.
     */
    @Min(0)
    private  BigDecimal salary;
    /**
     * The Commission pct.
     */
    private  BigDecimal commissionPct;
    /**
     * The Department.
     */
    @NotNull
    private  DepartmentDto department;

}