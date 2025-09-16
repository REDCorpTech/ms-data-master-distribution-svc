package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.ResolveIssue;
import com.ms.data.master.distribution.model.dto.distribution.ResolveIssueDetailsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class ResolveIssueMapperImpl implements ResolveIssueMapper {

    @Override
    public ResolveIssue toEntity(ResolveIssueDetailsDTO resolveIssueDetailsDTO) {
        if ( resolveIssueDetailsDTO == null ) {
            return null;
        }

        ResolveIssue.ResolveIssueBuilder<?, ?> resolveIssue = ResolveIssue.builder();

        resolveIssue.id( resolveIssueDetailsDTO.getId() );
        resolveIssue.resolveNote( resolveIssueDetailsDTO.getResolveNote() );
        resolveIssue.createdBy( resolveIssueDetailsDTO.getCreatedBy() );
        resolveIssue.createdAt( resolveIssueDetailsDTO.getCreatedAt() );
        resolveIssue.updatedBy( resolveIssueDetailsDTO.getUpdatedBy() );
        resolveIssue.updatedAt( resolveIssueDetailsDTO.getUpdatedAt() );

        return resolveIssue.build();
    }

    @Override
    public ResolveIssueDetailsDTO toDTO(ResolveIssue resolveIssue) {
        if ( resolveIssue == null ) {
            return null;
        }

        ResolveIssueDetailsDTO resolveIssueDetailsDTO = new ResolveIssueDetailsDTO();

        resolveIssueDetailsDTO.setId( resolveIssue.getId() );
        resolveIssueDetailsDTO.setResolveNote( resolveIssue.getResolveNote() );
        resolveIssueDetailsDTO.setCreatedBy( resolveIssue.getCreatedBy() );
        resolveIssueDetailsDTO.setCreatedAt( resolveIssue.getCreatedAt() );
        resolveIssueDetailsDTO.setUpdatedBy( resolveIssue.getUpdatedBy() );
        resolveIssueDetailsDTO.setUpdatedAt( resolveIssue.getUpdatedAt() );

        return resolveIssueDetailsDTO;
    }

    @Override
    public void updateFromDTOToEntity(ResolveIssueDetailsDTO resolveIssueDetailsDTO, ResolveIssue resolveIssue) {
        if ( resolveIssueDetailsDTO == null ) {
            return;
        }

        resolveIssue.setId( resolveIssueDetailsDTO.getId() );
        resolveIssue.setResolveNote( resolveIssueDetailsDTO.getResolveNote() );
        resolveIssue.setCreatedBy( resolveIssueDetailsDTO.getCreatedBy() );
        resolveIssue.setCreatedAt( resolveIssueDetailsDTO.getCreatedAt() );
        resolveIssue.setUpdatedBy( resolveIssueDetailsDTO.getUpdatedBy() );
        resolveIssue.setUpdatedAt( resolveIssueDetailsDTO.getUpdatedAt() );
    }
}
