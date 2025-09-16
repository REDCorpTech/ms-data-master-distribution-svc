package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.CancelReason;
import com.ms.data.master.distribution.model.dto.distribution.CancelReasonDetailsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class CancelReasonMapperImpl implements CancelReasonMapper {

    @Override
    public CancelReason toEntity(CancelReasonDetailsDTO cancelReasonDetailsDTO) {
        if ( cancelReasonDetailsDTO == null ) {
            return null;
        }

        CancelReason.CancelReasonBuilder<?, ?> cancelReason = CancelReason.builder();

        cancelReason.id( cancelReasonDetailsDTO.getId() );
        cancelReason.cancelReason( cancelReasonDetailsDTO.getCancelReason() );
        cancelReason.createdBy( cancelReasonDetailsDTO.getCreatedBy() );
        cancelReason.createdAt( cancelReasonDetailsDTO.getCreatedAt() );
        cancelReason.updatedBy( cancelReasonDetailsDTO.getUpdatedBy() );
        cancelReason.updatedAt( cancelReasonDetailsDTO.getUpdatedAt() );

        return cancelReason.build();
    }

    @Override
    public CancelReasonDetailsDTO toDTO(CancelReason cancelReason) {
        if ( cancelReason == null ) {
            return null;
        }

        CancelReasonDetailsDTO cancelReasonDetailsDTO = new CancelReasonDetailsDTO();

        cancelReasonDetailsDTO.setId( cancelReason.getId() );
        cancelReasonDetailsDTO.setCancelReason( cancelReason.getCancelReason() );
        cancelReasonDetailsDTO.setCreatedBy( cancelReason.getCreatedBy() );
        cancelReasonDetailsDTO.setCreatedAt( cancelReason.getCreatedAt() );
        cancelReasonDetailsDTO.setUpdatedBy( cancelReason.getUpdatedBy() );
        cancelReasonDetailsDTO.setUpdatedAt( cancelReason.getUpdatedAt() );

        return cancelReasonDetailsDTO;
    }

    @Override
    public void updateFromDTOToEntity(CancelReasonDetailsDTO cancelReasonDetailsDTO, CancelReason cancelReason) {
        if ( cancelReasonDetailsDTO == null ) {
            return;
        }

        cancelReason.setId( cancelReasonDetailsDTO.getId() );
        cancelReason.setCancelReason( cancelReasonDetailsDTO.getCancelReason() );
        cancelReason.setCreatedBy( cancelReasonDetailsDTO.getCreatedBy() );
        cancelReason.setCreatedAt( cancelReasonDetailsDTO.getCreatedAt() );
        cancelReason.setUpdatedBy( cancelReasonDetailsDTO.getUpdatedBy() );
        cancelReason.setUpdatedAt( cancelReasonDetailsDTO.getUpdatedAt() );
    }
}
