package com.ms.data.master.distribution.model.dto.distribution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private UUID id;
    private OrderRequestDetailsDTO orderRequestDetails;
    private GoodReceivedNoteDetailsDTO goodReceivedNoteDetails;
    private DeliveryNoteDetailsDTO deliveryNotesDetails;
    private RequestQRDestroyDetailsDTO requestDestroyDetails;
    private ResolveIssueDetailsDTO resolveIssueDetails;
    private CancelReasonDetailsDTO cancelReasonDetails;
    private String orderRequestStatus;
    private Boolean isGRI;
    private Boolean isStickerReceived;
    private LocalDateTime griDate;
    private LocalDateTime stickerReceivedDate;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
