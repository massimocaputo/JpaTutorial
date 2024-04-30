package com.acn.nemo.dto;

import com.acn.nemo.model.JobHistory;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link JobHistory}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JobHistoryDto implements Serializable {
    private static  long serialVersionUID = -8910271057089471014L;
    @NotNull
    private  JobHistoryIdDto id;
    @NotNull
    private  EmployeeDto employee;
    @NotNull
    private  LocalDate endDate;
    @NotNull
    private  JobDto job;
    @NotNull
    private  DepartmentDto department;
}