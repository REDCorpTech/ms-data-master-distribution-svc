package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.DeliveryNote;
import com.ms.data.master.distribution.model.GoodsReceivedNotes;
import com.ms.data.master.distribution.model.dto.distribution.DeliveryNoteDetailsDTO;
import com.ms.data.master.distribution.model.dto.distribution.GoodReceivedNoteDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoodReceivedNoteDetailMapper {
    GoodReceivedNoteDetailMapper INSTANCE = Mappers.getMapper(GoodReceivedNoteDetailMapper.class);

    GoodsReceivedNotes toEntity(GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO);

    GoodReceivedNoteDetailsDTO toDTO(GoodsReceivedNotes goodsReceivedNotes);

    void updateFromDTOToEntity(GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO, @MappingTarget GoodsReceivedNotes goodsReceivedNotes);
}
