package com.acn.nemo.mapper;

import com.acn.nemo.dto.EmployeeDto;
import com.acn.nemo.model.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {JobMapper.class, EmployeeMapper.class, DepartmentMapper.class, JobHistoryMapper.class})
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeDto employeeDto);

    EmployeeDto toDto(Employee employee);

//    @AfterMapping
//    default void linkJobHistories(@MappingTarget Employee employee) {
//        employee.getJobHistories().forEach(jobHistory -> jobHistory.setEmployee(employee));
//    }


//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Employee partialUpdate(EmployeeDto employeeDto, @MappingTarget Employee employee);
}