package com.ms.data.master.distribution.model.mapper;

import com.ms.data.master.distribution.model.OrderRequest;
import com.ms.data.master.distribution.model.dto.distribution.OrderRequestDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T02:09:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class OrderRequestMapperImpl implements OrderRequestMapper {

    @Override
    public OrderRequest toEntity(OrderRequestDTO orderRequestDTO) {
        if ( orderRequestDTO == null ) {
            return null;
        }

        OrderRequest.OrderRequestBuilder<?, ?> orderRequest = OrderRequest.builder();

        orderRequest.id( orderRequestDTO.getId() );
        orderRequest.orderRequestDetails( orderRequestDTO.getOrderRequestDetails() );
        orderRequest.goodReceivedNoteDetails( orderRequestDTO.getGoodReceivedNoteDetails() );
        orderRequest.deliveryNotesDetails( orderRequestDTO.getDeliveryNotesDetails() );
        orderRequest.requestDestroyDetails( orderRequestDTO.getRequestDestroyDetails() );
        orderRequest.resolveIssueDetails( orderRequestDTO.getResolveIssueDetails() );
        orderRequest.cancelReasonDetails( orderRequestDTO.getCancelReasonDetails() );
        orderRequest.orderRequestStatus( orderRequestDTO.getOrderRequestStatus() );
        orderRequest.isGRI( orderRequestDTO.getIsGRI() );
        orderRequest.isStickerReceived( orderRequestDTO.getIsStickerReceived() );
        orderRequest.griDate( orderRequestDTO.getGriDate() );
        orderRequest.stickerReceivedDate( orderRequestDTO.getStickerReceivedDate() );
        orderRequest.createdBy( orderRequestDTO.getCreatedBy() );
        orderRequest.createdAt( orderRequestDTO.getCreatedAt() );
        orderRequest.updatedBy( orderRequestDTO.getUpdatedBy() );
        orderRequest.updatedAt( orderRequestDTO.getUpdatedAt() );

        return orderRequest.build();
    }

    @Override
    public OrderRequestDTO toDTO(OrderRequest orderRequest) {
        if ( orderRequest == null ) {
            return null;
        }

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();

        orderRequestDTO.setId( orderRequest.getId() );
        orderRequestDTO.setOrderRequestDetails( orderRequest.getOrderRequestDetails() );
        orderRequestDTO.setGoodReceivedNoteDetails( orderRequest.getGoodReceivedNoteDetails() );
        orderRequestDTO.setDeliveryNotesDetails( orderRequest.getDeliveryNotesDetails() );
        orderRequestDTO.setRequestDestroyDetails( orderRequest.getRequestDestroyDetails() );
        orderRequestDTO.setResolveIssueDetails( orderRequest.getResolveIssueDetails() );
        orderRequestDTO.setCancelReasonDetails( orderRequest.getCancelReasonDetails() );
        orderRequestDTO.setOrderRequestStatus( orderRequest.getOrderRequestStatus() );
        orderRequestDTO.setIsGRI( orderRequest.getIsGRI() );
        orderRequestDTO.setIsStickerReceived( orderRequest.getIsStickerReceived() );
        orderRequestDTO.setGriDate( orderRequest.getGriDate() );
        orderRequestDTO.setStickerReceivedDate( orderRequest.getStickerReceivedDate() );
        orderRequestDTO.setCreatedBy( orderRequest.getCreatedBy() );
        orderRequestDTO.setCreatedAt( orderRequest.getCreatedAt() );
        orderRequestDTO.setUpdatedBy( orderRequest.getUpdatedBy() );
        orderRequestDTO.setUpdatedAt( orderRequest.getUpdatedAt() );

        return orderRequestDTO;
    }

    @Override
    public void updateFromDTOToEntity(OrderRequestDTO orderRequestDTO, OrderRequest orderRequest) {
        if ( orderRequestDTO == null ) {
            return;
        }

        orderRequest.setId( orderRequestDTO.getId() );
        orderRequest.setOrderRequestDetails( orderRequestDTO.getOrderRequestDetails() );
        orderRequest.setGoodReceivedNoteDetails( orderRequestDTO.getGoodReceivedNoteDetails() );
        orderRequest.setDeliveryNotesDetails( orderRequestDTO.getDeliveryNotesDetails() );
        orderRequest.setRequestDestroyDetails( orderRequestDTO.getRequestDestroyDetails() );
        orderRequest.setResolveIssueDetails( orderRequestDTO.getResolveIssueDetails() );
        orderRequest.setCancelReasonDetails( orderRequestDTO.getCancelReasonDetails() );
        orderRequest.setOrderRequestStatus( orderRequestDTO.getOrderRequestStatus() );
        orderRequest.setIsGRI( orderRequestDTO.getIsGRI() );
        orderRequest.setIsStickerReceived( orderRequestDTO.getIsStickerReceived() );
        orderRequest.setGriDate( orderRequestDTO.getGriDate() );
        orderRequest.setStickerReceivedDate( orderRequestDTO.getStickerReceivedDate() );
        orderRequest.setCreatedBy( orderRequestDTO.getCreatedBy() );
        orderRequest.setCreatedAt( orderRequestDTO.getCreatedAt() );
        orderRequest.setUpdatedBy( orderRequestDTO.getUpdatedBy() );
        orderRequest.setUpdatedAt( orderRequestDTO.getUpdatedAt() );
    }
}
