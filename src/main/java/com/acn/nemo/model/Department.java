package com.acn.nemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 7729171341854322713L;

    @Id
    @Column(name = "DEPARTMENT_ID", length = 4)
    private Long departmentId;

    @Column(name = "DEPARTMENT_NAME", length = 30)
    private String departmentName;

    @Column(name = "MANAGER_ID", length = 6)
    private Integer managerId;

    @Column(name = "LOCATION_ID", length = 4)
    private Integer locationId;

}
