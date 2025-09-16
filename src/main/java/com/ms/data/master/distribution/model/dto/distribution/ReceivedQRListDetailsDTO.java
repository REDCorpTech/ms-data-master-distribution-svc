package com.ms.data.master.distribution.model.dto.distribution;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceivedQRListDetailsDTO {
    private UUID id;
    private UUID orderRequestId;
    private UUID receivedQrListId;
    private UUID receivedQrCode;
}
