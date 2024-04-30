package com.acn.nemo.dto;

import com.acn.nemo.model.Job;
import com.acn.nemo.model.JobHistory;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Job}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JobDto implements Serializable {
    private static  long serialVersionUID = -6113533377508498339L;
    @Size(max = 10)
    private  String jobId;
    @NotNull
    @Size(max = 35)
    private  String jobTitle;
    private  Integer minSalary;
    private  Integer maxSalary;

}