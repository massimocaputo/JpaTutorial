package com.acn.nemo.mapper;

import com.acn.nemo.dto.LocationDto;
import com.acn.nemo.model.Location;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CountryMapper.class, DepartmentMapper.class})
public interface LocationMapper {
    LocationMapper MAPPER = Mappers.getMapper(LocationMapper.class);

    Location toEntity(LocationDto locationDto);

    LocationDto toDto(Location location);

//    @AfterMapping
//    default void linkDepartments(@MappingTarget Location location) {
//        location.getDepartments().forEach(department -> department.setLocation(location));
//    }
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Location partialUpdate(LocationDto locationDto, @MappingTarget Location location);
}