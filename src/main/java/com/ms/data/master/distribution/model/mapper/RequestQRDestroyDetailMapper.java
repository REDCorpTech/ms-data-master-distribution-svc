package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.RequestQRDestroy;
import com.ms.data.master.distribution.model.dto.distribution.RequestQRDestroyDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestQRDestroyDetailMapper {
    RequestQRDestroyDetailMapper INSTANCE = Mappers.getMapper(RequestQRDestroyDetailMapper.class);

    RequestQRDestroy toEntity(RequestQRDestroyDetailsDTO requestQRDestroyDetailsDTO);

    RequestQRDestroyDetailsDTO toDTO(RequestQRDestroy requestQRDestroy);

    void updateFromDTOToEntity(RequestQRDestroyDetailsDTO requestQRDestroyDetailsDTO, @MappingTarget RequestQRDestroy requestQRDestroy);
}
