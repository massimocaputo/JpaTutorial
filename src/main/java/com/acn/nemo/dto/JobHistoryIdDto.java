package com.acn.nemo.dto;

import com.acn.nemo.model.JobHistoryId;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link JobHistoryId}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JobHistoryIdDto implements Serializable {
    private static  long serialVersionUID = -4818420010900379465L;
    @NotNull
    private  Integer employeeId;
    @NotNull
    private  LocalDate startDate;
}