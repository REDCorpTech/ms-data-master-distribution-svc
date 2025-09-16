package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.RequestQRDestroy;
import com.ms.data.master.distribution.model.dto.distribution.RequestQRDestroyDetailsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class RequestQRDestroyDetailMapperImpl implements RequestQRDestroyDetailMapper {

    @Override
    public RequestQRDestroy toEntity(RequestQRDestroyDetailsDTO requestQRDestroyDetailsDTO) {
        if ( requestQRDestroyDetailsDTO == null ) {
            return null;
        }

        RequestQRDestroy.RequestQRDestroyBuilder<?, ?> requestQRDestroy = RequestQRDestroy.builder();

        requestQRDestroy.id( requestQRDestroyDetailsDTO.getId() );
        requestQRDestroy.brandId( requestQRDestroyDetailsDTO.getBrandId() );
        requestQRDestroy.requestDestroyRangeFrom( requestQRDestroyDetailsDTO.getRequestDestroyRangeFrom() );
        requestQRDestroy.requestDestroyRangeTo( requestQRDestroyDetailsDTO.getRequestDestroyRangeTo() );
        requestQRDestroy.requestDestroyNote( requestQRDestroyDetailsDTO.getRequestDestroyNote() );
        requestQRDestroy.createdBy( requestQRDestroyDetailsDTO.getCreatedBy() );
        requestQRDestroy.createdAt( requestQRDestroyDetailsDTO.getCreatedAt() );
        requestQRDestroy.updatedBy( requestQRDestroyDetailsDTO.getUpdatedBy() );
        requestQRDestroy.updatedAt( requestQRDestroyDetailsDTO.getUpdatedAt() );

        return requestQRDestroy.build();
    }

    @Override
    public RequestQRDestroyDetailsDTO toDTO(RequestQRDestroy requestQRDestroy) {
        if ( requestQRDestroy == null ) {
            return null;
        }

        RequestQRDestroyDetailsDTO requestQRDestroyDetailsDTO = new RequestQRDestroyDetailsDTO();

        requestQRDestroyDetailsDTO.setId( requestQRDestroy.getId() );
        requestQRDestroyDetailsDTO.setBrandId( requestQRDestroy.getBrandId() );
        requestQRDestroyDetailsDTO.setRequestDestroyRangeFrom( requestQRDestroy.getRequestDestroyRangeFrom() );
        requestQRDestroyDetailsDTO.setRequestDestroyRangeTo( requestQRDestroy.getRequestDestroyRangeTo() );
        requestQRDestroyDetailsDTO.setRequestDestroyNote( requestQRDestroy.getRequestDestroyNote() );
        requestQRDestroyDetailsDTO.setCreatedBy( requestQRDestroy.getCreatedBy() );
        requestQRDestroyDetailsDTO.setCreatedAt( requestQRDestroy.getCreatedAt() );
        requestQRDestroyDetailsDTO.setUpdatedBy( requestQRDestroy.getUpdatedBy() );
        requestQRDestroyDetailsDTO.setUpdatedAt( requestQRDestroy.getUpdatedAt() );

        return requestQRDestroyDetailsDTO;
    }

    @Override
    public void updateFromDTOToEntity(RequestQRDestroyDetailsDTO requestQRDestroyDetailsDTO, RequestQRDestroy requestQRDestroy) {
        if ( requestQRDestroyDetailsDTO == null ) {
            return;
        }

        requestQRDestroy.setId( requestQRDestroyDetailsDTO.getId() );
        requestQRDestroy.setBrandId( requestQRDestroyDetailsDTO.getBrandId() );
        requestQRDestroy.setRequestDestroyRangeFrom( requestQRDestroyDetailsDTO.getRequestDestroyRangeFrom() );
        requestQRDestroy.setRequestDestroyRangeTo( requestQRDestroyDetailsDTO.getRequestDestroyRangeTo() );
        requestQRDestroy.setRequestDestroyNote( requestQRDestroyDetailsDTO.getRequestDestroyNote() );
        requestQRDestroy.setCreatedBy( requestQRDestroyDetailsDTO.getCreatedBy() );
        requestQRDestroy.setCreatedAt( requestQRDestroyDetailsDTO.getCreatedAt() );
        requestQRDestroy.setUpdatedBy( requestQRDestroyDetailsDTO.getUpdatedBy() );
        requestQRDestroy.setUpdatedAt( requestQRDestroyDetailsDTO.getUpdatedAt() );
    }
}
