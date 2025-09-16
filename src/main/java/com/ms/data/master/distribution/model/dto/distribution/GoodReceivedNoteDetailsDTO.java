package com.ms.data.master.distribution.model.dto.distribution;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodReceivedNoteDetailsDTO {
    private UUID id;
    private String recievedBy;
    private String confirmedBy;
    private LocalDateTime receivedDate;
    private String receivedQrRangeFrom;
    private String receivedQrRangeTo;
    private Integer receivedQrQty;
    private UUID recievedQrListId;
    private UUID receivedStatusId;
    private String additionalInformation;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
