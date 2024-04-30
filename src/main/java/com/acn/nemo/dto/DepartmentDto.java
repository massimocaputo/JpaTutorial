package com.acn.nemo.dto;

import com.acn.nemo.model.Department;
import com.acn.nemo.model.JobHistory;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Department}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DepartmentDto implements Serializable {
    private static  long serialVersionUID = -4719650339933539131L;
    private  Short id;
    @NotNull
    @Size(max = 30)
    private  String departmentName;
    @NotNull
    private  LocationDto location;
//    @NotNull
//    private  Set<EmployeeDto> employees;
//    @NotNull
//    private  Set<JobHistory> jobHistories;
}