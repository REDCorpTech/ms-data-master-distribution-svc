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
@Table(name = "t_address_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "order_request_id")
    private UUID orderRequestId;

    @Column(name = "qr_list_id")
    private UUID qrListId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "brand_id")
    private String brandId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "qr_range_from")
    private String qrRangeFrom;

    @Column(name = "qr_range_to")
    private String qrRangeTo;

    @Column(name = "qr_qty")
    private String qrQty;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
