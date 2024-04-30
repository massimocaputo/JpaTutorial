package com.acn.nemo.dto;

import com.acn.nemo.model.Region;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Region}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RegionDto implements Serializable {
    private static  long serialVersionUID = -2146823322984128671L;
    private  Long id;
    @Size(max = 25)
    private  String regionName;
    @NotNull
    private  Set<CountryDto> countries;
}