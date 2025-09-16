package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.GoodsReceivedNotes;
import com.ms.data.master.distribution.model.dto.distribution.GoodReceivedNoteDetailsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class GoodReceivedNoteDetailMapperImpl implements GoodReceivedNoteDetailMapper {

    @Override
    public GoodsReceivedNotes toEntity(GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO) {
        if ( goodReceivedNoteDetailsDTO == null ) {
            return null;
        }

        GoodsReceivedNotes.GoodsReceivedNotesBuilder<?, ?> goodsReceivedNotes = GoodsReceivedNotes.builder();

        goodsReceivedNotes.id( goodReceivedNoteDetailsDTO.getId() );
        goodsReceivedNotes.recievedBy( goodReceivedNoteDetailsDTO.getRecievedBy() );
        goodsReceivedNotes.confirmedBy( goodReceivedNoteDetailsDTO.getConfirmedBy() );
        goodsReceivedNotes.receivedDate( goodReceivedNoteDetailsDTO.getReceivedDate() );
        goodsReceivedNotes.receivedQrRangeFrom( goodReceivedNoteDetailsDTO.getReceivedQrRangeFrom() );
        goodsReceivedNotes.receivedQrRangeTo( goodReceivedNoteDetailsDTO.getReceivedQrRangeTo() );
        goodsReceivedNotes.receivedQrQty( goodReceivedNoteDetailsDTO.getReceivedQrQty() );
        goodsReceivedNotes.recievedQrListId( goodReceivedNoteDetailsDTO.getRecievedQrListId() );
        goodsReceivedNotes.receivedStatusId( goodReceivedNoteDetailsDTO.getReceivedStatusId() );
        goodsReceivedNotes.additionalInformation( goodReceivedNoteDetailsDTO.getAdditionalInformation() );
        goodsReceivedNotes.createdBy( goodReceivedNoteDetailsDTO.getCreatedBy() );
        goodsReceivedNotes.createdAt( goodReceivedNoteDetailsDTO.getCreatedAt() );
        goodsReceivedNotes.updatedBy( goodReceivedNoteDetailsDTO.getUpdatedBy() );
        goodsReceivedNotes.updatedAt( goodReceivedNoteDetailsDTO.getUpdatedAt() );

        return goodsReceivedNotes.build();
    }

    @Override
    public GoodReceivedNoteDetailsDTO toDTO(GoodsReceivedNotes goodsReceivedNotes) {
        if ( goodsReceivedNotes == null ) {
            return null;
        }

        GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO = new GoodReceivedNoteDetailsDTO();

        goodReceivedNoteDetailsDTO.setId( goodsReceivedNotes.getId() );
        goodReceivedNoteDetailsDTO.setRecievedBy( goodsReceivedNotes.getRecievedBy() );
        goodReceivedNoteDetailsDTO.setConfirmedBy( goodsReceivedNotes.getConfirmedBy() );
        goodReceivedNoteDetailsDTO.setReceivedDate( goodsReceivedNotes.getReceivedDate() );
        goodReceivedNoteDetailsDTO.setReceivedQrRangeFrom( goodsReceivedNotes.getReceivedQrRangeFrom() );
        goodReceivedNoteDetailsDTO.setReceivedQrRangeTo( goodsReceivedNotes.getReceivedQrRangeTo() );
        goodReceivedNoteDetailsDTO.setReceivedQrQty( goodsReceivedNotes.getReceivedQrQty() );
        goodReceivedNoteDetailsDTO.setRecievedQrListId( goodsReceivedNotes.getRecievedQrListId() );
        goodReceivedNoteDetailsDTO.setReceivedStatusId( goodsReceivedNotes.getReceivedStatusId() );
        goodReceivedNoteDetailsDTO.setAdditionalInformation( goodsReceivedNotes.getAdditionalInformation() );
        goodReceivedNoteDetailsDTO.setCreatedBy( goodsReceivedNotes.getCreatedBy() );
        goodReceivedNoteDetailsDTO.setCreatedAt( goodsReceivedNotes.getCreatedAt() );
        goodReceivedNoteDetailsDTO.setUpdatedBy( goodsReceivedNotes.getUpdatedBy() );
        goodReceivedNoteDetailsDTO.setUpdatedAt( goodsReceivedNotes.getUpdatedAt() );

        return goodReceivedNoteDetailsDTO;
    }

    @Override
    public void updateFromDTOToEntity(GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO, GoodsReceivedNotes goodsReceivedNotes) {
        if ( goodReceivedNoteDetailsDTO == null ) {
            return;
        }

        goodsReceivedNotes.setId( goodReceivedNoteDetailsDTO.getId() );
        goodsReceivedNotes.setRecievedBy( goodReceivedNoteDetailsDTO.getRecievedBy() );
        goodsReceivedNotes.setConfirmedBy( goodReceivedNoteDetailsDTO.getConfirmedBy() );
        goodsReceivedNotes.setReceivedDate( goodReceivedNoteDetailsDTO.getReceivedDate() );
        goodsReceivedNotes.setReceivedQrRangeFrom( goodReceivedNoteDetailsDTO.getReceivedQrRangeFrom() );
        goodsReceivedNotes.setReceivedQrRangeTo( goodReceivedNoteDetailsDTO.getReceivedQrRangeTo() );
        goodsReceivedNotes.setReceivedQrQty( goodReceivedNoteDetailsDTO.getReceivedQrQty() );
        goodsReceivedNotes.setRecievedQrListId( goodReceivedNoteDetailsDTO.getRecievedQrListId() );
        goodsReceivedNotes.setReceivedStatusId( goodReceivedNoteDetailsDTO.getReceivedStatusId() );
        goodsReceivedNotes.setAdditionalInformation( goodReceivedNoteDetailsDTO.getAdditionalInformation() );
        goodsReceivedNotes.setCreatedBy( goodReceivedNoteDetailsDTO.getCreatedBy() );
        goodsReceivedNotes.setCreatedAt( goodReceivedNoteDetailsDTO.getCreatedAt() );
        goodsReceivedNotes.setUpdatedBy( goodReceivedNoteDetailsDTO.getUpdatedBy() );
        goodsReceivedNotes.setUpdatedAt( goodReceivedNoteDetailsDTO.getUpdatedAt() );
    }
}
