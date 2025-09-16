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
public class AddressDetailsDTO {
    private UUID id;
    private Integer orderNumber;
    private String brandId;
    private String brandName;
    private String receiver;
    private String qrRangeFrom;
    private String qrRangeTo;
    private String qrQty;
    private String qrListId;
}
