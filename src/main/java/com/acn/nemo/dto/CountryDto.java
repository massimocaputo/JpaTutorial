package com.acn.nemo.dto;

import com.acn.nemo.model.Country;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Country}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CountryDto implements Serializable {
    private static  long serialVersionUID = -7194766351075323423L;
    @Size(max = 2)
    private  String countryId;
    @Size(max = 40)
    private  String countryName;
//    @NotNull
//    private  RegionDto region;
//    @NotNull
//    private  Set<LocationDto> locations;

}