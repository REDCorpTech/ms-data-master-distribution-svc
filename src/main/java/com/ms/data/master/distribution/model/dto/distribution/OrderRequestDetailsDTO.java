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
public class OrderRequestDetailsDTO {
    private UUID id;
    private String brandId;
    private String brandName;
    private String receiverName;
    private String qrRangeFrom;
    private String qrRangeTo;
    private String qrRangeQty;
    private AddressDetailsDTO addressDetails;
    private QRListDetailsDTO qrListDetails;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
