package com.ms.data.master.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_delivery_note")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryNote {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "order_request_id")
    private UUID orderRequestId;

    @Column(name = "third_pl_name")
    private String thirdPlName;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "courier_name")
    private String courierName;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "airway_bill")
    private String airwayBill;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
