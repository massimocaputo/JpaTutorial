package com.acn.nemo.mapper;

import com.acn.nemo.dto.DepartmentDto;
import com.acn.nemo.model.Department;
import com.acn.nemo.model.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {LocationMapper.class, EmployeeMapper.class, JobHistoryMapper.class})
public interface DepartmentMapper {

    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    Department toEntity(DepartmentDto departmentDto);

    DepartmentDto toDto(Department department);

//    @AfterMapping
//    default void linkEmployees(@MappingTarget DepartmentDto departmentDto) {
//        departmentDto.getEmployees().forEach(employeeDto -> employeeDto.setDepartment(departmentDto));
//    }
//
//    @AfterMapping
//    default void linkJobHistories(@MappingTarget DepartmentDto departmentDto) {
//        departmentDto.getJobHistories().forEach(jobHistory -> jobHistory.setDepartment(departmentDto));
//    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Department partialUpdate(DepartmentDto departmentDto, @MappingTarget Department department);
}