package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.DeliveryNote;
import com.ms.data.master.distribution.model.ResolveIssue;
import com.ms.data.master.distribution.model.dto.distribution.DeliveryNoteDetailsDTO;
import com.ms.data.master.distribution.model.dto.distribution.ResolveIssueDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResolveIssueMapper {
    ResolveIssueMapper INSTANCE = Mappers.getMapper(ResolveIssueMapper.class);

    ResolveIssue toEntity(ResolveIssueDetailsDTO resolveIssueDetailsDTO);

    ResolveIssueDetailsDTO toDTO(ResolveIssue resolveIssue);

    void updateFromDTOToEntity(ResolveIssueDetailsDTO resolveIssueDetailsDTO, @MappingTarget ResolveIssue resolveIssue);
}
