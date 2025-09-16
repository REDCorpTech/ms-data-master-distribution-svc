package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.AddressDetails;
import com.ms.data.master.distribution.model.dto.distribution.AddressDetailsDTO;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:15+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class AddressDetailMapperImpl implements AddressDetailMapper {

    @Override
    public AddressDetails toEntity(AddressDetailsDTO addressDetailsDTO) {
        if ( addressDetailsDTO == null ) {
            return null;
        }

        AddressDetails.AddressDetailsBuilder<?, ?> addressDetails = AddressDetails.builder();

        addressDetails.id( addressDetailsDTO.getId() );
        if ( addressDetailsDTO.getQrListId() != null ) {
            addressDetails.qrListId( UUID.fromString( addressDetailsDTO.getQrListId() ) );
        }
        addressDetails.orderNumber( addressDetailsDTO.getOrderNumber() );
        addressDetails.brandId( addressDetailsDTO.getBrandId() );
        addressDetails.brandName( addressDetailsDTO.getBrandName() );
        addressDetails.receiver( addressDetailsDTO.getReceiver() );
        addressDetails.qrRangeFrom( addressDetailsDTO.getQrRangeFrom() );
        addressDetails.qrRangeTo( addressDetailsDTO.getQrRangeTo() );
        addressDetails.qrQty( addressDetailsDTO.getQrQty() );

        return addressDetails.build();
    }

    @Override
    public AddressDetailsDTO toDTO(AddressDetails addressDetails) {
        if ( addressDetails == null ) {
            return null;
        }

        AddressDetailsDTO addressDetailsDTO = new AddressDetailsDTO();

        addressDetailsDTO.setId( addressDetails.getId() );
        addressDetailsDTO.setOrderNumber( addressDetails.getOrderNumber() );
        addressDetailsDTO.setBrandId( addressDetails.getBrandId() );
        addressDetailsDTO.setBrandName( addressDetails.getBrandName() );
        addressDetailsDTO.setReceiver( addressDetails.getReceiver() );
        addressDetailsDTO.setQrRangeFrom( addressDetails.getQrRangeFrom() );
        addressDetailsDTO.setQrRangeTo( addressDetails.getQrRangeTo() );
        addressDetailsDTO.setQrQty( addressDetails.getQrQty() );
        if ( addressDetails.getQrListId() != null ) {
            addressDetailsDTO.setQrListId( addressDetails.getQrListId().toString() );
        }

        return addressDetailsDTO;
    }

    @Override
    public void updateFromDTOToEntity(AddressDetailsDTO addressDetailsDTO, AddressDetails addressDetails) {
        if ( addressDetailsDTO == null ) {
            return;
        }

        addressDetails.setId( addressDetailsDTO.getId() );
        if ( addressDetailsDTO.getQrListId() != null ) {
            addressDetails.setQrListId( UUID.fromString( addressDetailsDTO.getQrListId() ) );
        }
        else {
            addressDetails.setQrListId( null );
        }
        addressDetails.setOrderNumber( addressDetailsDTO.getOrderNumber() );
        addressDetails.setBrandId( addressDetailsDTO.getBrandId() );
        addressDetails.setBrandName( addressDetailsDTO.getBrandName() );
        addressDetails.setReceiver( addressDetailsDTO.getReceiver() );
        addressDetails.setQrRangeFrom( addressDetailsDTO.getQrRangeFrom() );
        addressDetails.setQrRangeTo( addressDetailsDTO.getQrRangeTo() );
        addressDetails.setQrQty( addressDetailsDTO.getQrQty() );
    }
}
