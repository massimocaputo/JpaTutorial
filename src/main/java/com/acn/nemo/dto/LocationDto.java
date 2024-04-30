package com.acn.nemo.dto;

import com.acn.nemo.model.Department;
import com.acn.nemo.model.Location;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Location}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LocationDto implements Serializable {
    private static  long serialVersionUID = -3012748261511788679L;
    private  Short id;
    @Size(max = 40)
    private  String streetAddress;
    @Size(max = 12)
    private  String postalCode;
    @NotNull
    @Size(max = 30)
    private  String city;
    @Size(max = 25)
    private  String stateProvince;
    private  CountryDto country;
//    @NotNull
//    private  Set<Department> departments;
}