package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.AddressDetails;
import com.ms.data.master.distribution.model.DeliveryNote;
import com.ms.data.master.distribution.model.dto.distribution.AddressDetailsDTO;
import com.ms.data.master.distribution.model.dto.distribution.DeliveryNoteDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryNoteMapper {
    DeliveryNoteMapper INSTANCE = Mappers.getMapper(DeliveryNoteMapper.class);

    DeliveryNote toEntity(DeliveryNoteDetailsDTO deliveryNoteDetailsDTO);

    DeliveryNoteDetailsDTO toDTO(DeliveryNote deliveryNote);

    void updateFromDTOToEntity(DeliveryNoteDetailsDTO deliveryNoteDetailsDTO, @MappingTarget DeliveryNote deliveryNote);
}
