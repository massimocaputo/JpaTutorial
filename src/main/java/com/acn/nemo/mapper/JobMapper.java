package com.acn.nemo.mapper;

import com.acn.nemo.model.Job;
import com.acn.nemo.dto.JobDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {EmployeeMapper.class, JobHistoryMapper.class})
public interface JobMapper {
    JobMapper MAPPER = Mappers.getMapper(JobMapper.class);

    Job toEntity(JobDto jobDto);

    JobDto toDto(Job job);

//    @AfterMapping
//    default void linkEmployees(@MappingTarget Job job) {
//        job.getEmployees().forEach(employee -> employee.setJob(job));
//    }
//
//    @AfterMapping
//    default void linkJobHistories(@MappingTarget Job job) {
//        job.getJobHistories().forEach(jobHistory -> jobHistory.setJob(job));
//    }
//
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Job partialUpdate(JobDto jobDto, @MappingTarget Job job);
}