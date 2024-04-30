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
@Table(name = "JOBS")
@NamedQueries({
        @NamedQuery(name = "Job.findByJobIdEqualsIgnoreCase", query = "select j from Job j where upper(j.jobId) = upper(:jobId)")
})
public class Job implements Serializable {
    private static final long serialVersionUID = -3219834589198870889L;
    @Id
    @Size(max = 10)
    @Column(name = "JOB_ID", nullable = false, length = 10)
    private String jobId;

    @Size(max = 35)
    @NotNull
    @Column(name = "JOB_TITLE", nullable = false, length = 35)
    private String jobTitle;

    @Column(name = "MIN_SALARY")
    private Integer minSalary;

    @Column(name = "MAX_SALARY")
    private Integer maxSalary;

    @OneToMany(mappedBy = "job")
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories = new LinkedHashSet<>();

}