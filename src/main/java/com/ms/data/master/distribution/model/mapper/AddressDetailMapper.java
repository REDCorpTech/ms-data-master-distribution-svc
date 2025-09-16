package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.AddressDetails;
import com.ms.data.master.distribution.model.OrderRequest;
import com.ms.data.master.distribution.model.dto.distribution.AddressDetailsDTO;
import com.ms.data.master.distribution.model.dto.distribution.OrderRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressDetailMapper {
    AddressDetailMapper INSTANCE = Mappers.getMapper(AddressDetailMapper.class);

    AddressDetails toEntity(AddressDetailsDTO addressDetailsDTO);

    AddressDetailsDTO toDTO(AddressDetails addressDetails);

    void updateFromDTOToEntity(AddressDetailsDTO addressDetailsDTO, @MappingTarget AddressDetails addressDetails);
}
