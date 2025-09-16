package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.AddressDetails;
import com.ms.data.master.distribution.model.QRList;
import com.ms.data.master.distribution.model.dto.distribution.AddressDetailsDTO;
import com.ms.data.master.distribution.model.dto.distribution.QRListDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QRListDetailMapper {
    QRListDetailMapper INSTANCE = Mappers.getMapper(QRListDetailMapper.class);

    QRList toEntity(QRListDetailsDTO qrListDetailsDTO);

    QRListDetailsDTO toDTO(QRList qrList);

    void updateFromDTOToEntity(QRListDetailsDTO qrListDetailsDTO, @MappingTarget QRList qrList);
}
