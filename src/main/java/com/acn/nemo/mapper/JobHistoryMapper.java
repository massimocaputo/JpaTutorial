package com.acn.nemo.mapper;

import com.acn.nemo.dto.JobHistoryDto;
import com.acn.nemo.model.JobHistory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {JobHistoryIdMapper.class, EmployeeMapper.class, JobMapper.class, DepartmentMapper.class})
public interface JobHistoryMapper {
    JobHistoryMapper MAPPER = Mappers.getMapper(JobHistoryMapper.class);

    JobHistory toEntity(JobHistoryDto jobHistoryDto);

    JobHistoryDto toDto(JobHistory jobHistory);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    JobHistory partialUpdate(JobHistoryDto jobHistoryDto, @MappingTarget JobHistory jobHistory);
}