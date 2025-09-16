package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.CancelReason;
import com.ms.data.master.distribution.model.DeliveryNote;
import com.ms.data.master.distribution.model.dto.distribution.CancelReasonDetailsDTO;
import com.ms.data.master.distribution.model.dto.distribution.DeliveryNoteDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CancelReasonMapper {
    CancelReasonMapper INSTANCE = Mappers.getMapper(CancelReasonMapper.class);

    CancelReason toEntity(CancelReasonDetailsDTO cancelReasonDetailsDTO);

    CancelReasonDetailsDTO toDTO(CancelReason cancelReason);

    void updateFromDTOToEntity(CancelReasonDetailsDTO cancelReasonDetailsDTO, @MappingTarget CancelReason cancelReason);
}
