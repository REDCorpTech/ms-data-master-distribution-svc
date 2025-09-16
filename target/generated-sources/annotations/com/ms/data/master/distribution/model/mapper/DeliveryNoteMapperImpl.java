package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.DeliveryNote;
import com.ms.data.master.distribution.model.dto.distribution.DeliveryNoteDetailsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class DeliveryNoteMapperImpl implements DeliveryNoteMapper {

    @Override
    public DeliveryNote toEntity(DeliveryNoteDetailsDTO deliveryNoteDetailsDTO) {
        if ( deliveryNoteDetailsDTO == null ) {
            return null;
        }

        DeliveryNote.DeliveryNoteBuilder<?, ?> deliveryNote = DeliveryNote.builder();

        deliveryNote.id( deliveryNoteDetailsDTO.getId() );
        deliveryNote.thirdPlName( deliveryNoteDetailsDTO.getThirdPlName() );
        deliveryNote.vehicleType( deliveryNoteDetailsDTO.getVehicleType() );
        deliveryNote.courierName( deliveryNoteDetailsDTO.getCourierName() );
        deliveryNote.licencePlate( deliveryNoteDetailsDTO.getLicencePlate() );
        deliveryNote.airwayBill( deliveryNoteDetailsDTO.getAirwayBill() );

        return deliveryNote.build();
    }

    @Override
    public DeliveryNoteDetailsDTO toDTO(DeliveryNote deliveryNote) {
        if ( deliveryNote == null ) {
            return null;
        }

        DeliveryNoteDetailsDTO deliveryNoteDetailsDTO = new DeliveryNoteDetailsDTO();

        deliveryNoteDetailsDTO.setId( deliveryNote.getId() );
        deliveryNoteDetailsDTO.setThirdPlName( deliveryNote.getThirdPlName() );
        deliveryNoteDetailsDTO.setVehicleType( deliveryNote.getVehicleType() );
        deliveryNoteDetailsDTO.setCourierName( deliveryNote.getCourierName() );
        deliveryNoteDetailsDTO.setLicencePlate( deliveryNote.getLicencePlate() );
        deliveryNoteDetailsDTO.setAirwayBill( deliveryNote.getAirwayBill() );

        return deliveryNoteDetailsDTO;
    }

    @Override
    public void updateFromDTOToEntity(DeliveryNoteDetailsDTO deliveryNoteDetailsDTO, DeliveryNote deliveryNote) {
        if ( deliveryNoteDetailsDTO == null ) {
            return;
        }

        deliveryNote.setId( deliveryNoteDetailsDTO.getId() );
        deliveryNote.setThirdPlName( deliveryNoteDetailsDTO.getThirdPlName() );
        deliveryNote.setVehicleType( deliveryNoteDetailsDTO.getVehicleType() );
        deliveryNote.setCourierName( deliveryNoteDetailsDTO.getCourierName() );
        deliveryNote.setLicencePlate( deliveryNoteDetailsDTO.getLicencePlate() );
        deliveryNote.setAirwayBill( deliveryNoteDetailsDTO.getAirwayBill() );
    }
}
