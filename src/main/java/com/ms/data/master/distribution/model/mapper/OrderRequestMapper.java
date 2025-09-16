package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.OrderRequest;
import com.ms.data.master.distribution.model.dto.distribution.OrderRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderRequestMapper {
    OrderRequestMapper INSTANCE = Mappers.getMapper(OrderRequestMapper.class);

    OrderRequest toEntity(OrderRequestDTO orderRequestDTO);

    OrderRequestDTO toDTO(OrderRequest orderRequest);

    void updateFromDTOToEntity(OrderRequestDTO orderRequestDTO, @MappingTarget OrderRequest orderRequest);
}
