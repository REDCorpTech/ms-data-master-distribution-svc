package com.ms.data.master.distribution.model.dto.distribution;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryNoteDetailsDTO {
    private UUID id;
    private String thirdPlName;
    private String vehicleType;
    private String courierName;
    private String licencePlate;
    private String airwayBill;
}
