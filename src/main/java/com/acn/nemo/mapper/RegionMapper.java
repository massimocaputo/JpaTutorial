package com.acn.nemo.mapper;

import com.acn.nemo.model.Region;
import com.acn.nemo.dto.RegionDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CountryMapper.class})
public interface RegionMapper {
    RegionMapper MAPPER = Mappers.getMapper(RegionMapper.class);

    Region toEntity(RegionDto regionDto);

    RegionDto toDto(Region region);

//    @AfterMapping
//    default void linkCountries(@MappingTarget Region region) {
//        region.getCountries().forEach(country -> country.setRegion(region));
//    }
//
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Region partialUpdate(RegionDto regionDto, @MappingTarget Region region);

}