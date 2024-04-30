package com.acn.nemo.mapper;

import com.acn.nemo.dto.CountryDto;
import com.acn.nemo.model.Country;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {RegionMapper.class, LocationMapper.class})
public interface CountryMapper {
    CountryMapper MAPPER = Mappers.getMapper(CountryMapper.class);
    Country toEntity(CountryDto countryDto);

    CountryDto toDto(Country country);

//    @AfterMapping
//    default void linkLocations(@MappingTarget Country country) {
//        country.getLocations().forEach(location -> location.setCountry(country));
//    }
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Country partialUpdate(CountryDto countryDto, @MappingTarget Country country);

}