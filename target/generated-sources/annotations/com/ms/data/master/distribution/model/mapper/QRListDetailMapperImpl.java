package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.QRList;
import com.ms.data.master.distribution.model.dto.distribution.QRListDetailsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class QRListDetailMapperImpl implements QRListDetailMapper {

    @Override
    public QRList toEntity(QRListDetailsDTO qrListDetailsDTO) {
        if ( qrListDetailsDTO == null ) {
            return null;
        }

        QRList.QRListBuilder<?, ?> qRList = QRList.builder();

        qRList.id( qrListDetailsDTO.getId() );
        qRList.qrCode( qrListDetailsDTO.getQrCode() );
        qRList.createdBy( qrListDetailsDTO.getCreatedBy() );
        qRList.createdAt( qrListDetailsDTO.getCreatedAt() );
        qRList.updatedBy( qrListDetailsDTO.getUpdatedBy() );
        qRList.updatedAt( qrListDetailsDTO.getUpdatedAt() );

        return qRList.build();
    }

    @Override
    public QRListDetailsDTO toDTO(QRList qrList) {
        if ( qrList == null ) {
            return null;
        }

        QRListDetailsDTO qRListDetailsDTO = new QRListDetailsDTO();

        qRListDetailsDTO.setId( qrList.getId() );
        qRListDetailsDTO.setQrCode( qrList.getQrCode() );
        qRListDetailsDTO.setCreatedBy( qrList.getCreatedBy() );
        qRListDetailsDTO.setCreatedAt( qrList.getCreatedAt() );
        qRListDetailsDTO.setUpdatedBy( qrList.getUpdatedBy() );
        qRListDetailsDTO.setUpdatedAt( qrList.getUpdatedAt() );

        return qRListDetailsDTO;
    }

    @Override
    public void updateFromDTOToEntity(QRListDetailsDTO qrListDetailsDTO, QRList qrList) {
        if ( qrListDetailsDTO == null ) {
            return;
        }

        qrList.setId( qrListDetailsDTO.getId() );
        qrList.setQrCode( qrListDetailsDTO.getQrCode() );
        qrList.setCreatedBy( qrListDetailsDTO.getCreatedBy() );
        qrList.setCreatedAt( qrListDetailsDTO.getCreatedAt() );
        qrList.setUpdatedBy( qrListDetailsDTO.getUpdatedBy() );
        qrList.setUpdatedAt( qrListDetailsDTO.getUpdatedAt() );
    }
}
