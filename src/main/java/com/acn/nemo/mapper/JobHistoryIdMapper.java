package com.acn.nemo.mapper;

import com.acn.nemo.model.JobHistoryId;
import com.acn.nemo.dto.JobHistoryIdDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobHistoryIdMapper {
    JobHistoryIdMapper MAPPER = Mappers.getMapper(JobHistoryIdMapper.class);

    JobHistoryId toEntity(JobHistoryIdDto jobHistoryIdDto);

    JobHistoryIdDto toDto(JobHistoryId jobHistoryId);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    JobHistoryId partialUpdate(JobHistoryIdDto jobHistoryIdDto, @MappingTarget JobHistoryId jobHistoryId);
}