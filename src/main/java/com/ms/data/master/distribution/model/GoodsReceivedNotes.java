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
@Table(name = "t_good_receive_notes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsReceivedNotes {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "order_request_id")
    private UUID orderRequestId;

    @Column(name = "received_by")
    private String recievedBy;

    @Column(name = "confirmed_by")
    private String confirmedBy;

    @Column(name = "received_date")
    private LocalDateTime receivedDate;

    @Column(name = "received_qr_range_from")
    private String receivedQrRangeFrom;

    @Column(name = "received_qr_range_to")
    private String receivedQrRangeTo;

    @Column(name = "received_qr_qty")
    private Integer receivedQrQty;

    @Column(name = "received_qr_list_id")
    private UUID recievedQrListId;

    @Column(name = "received_status_id")
    private UUID receivedStatusId;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
