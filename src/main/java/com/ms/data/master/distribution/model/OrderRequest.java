package com.ms.data.master.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ms.data.master.distribution.model.dto.distribution.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_order_request")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequest {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "order_request_details")
    private OrderRequestDetailsDTO orderRequestDetails;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "good_received_notes_details")
    private GoodReceivedNoteDetailsDTO goodReceivedNoteDetails;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "delivery_notes_details")
    private DeliveryNoteDetailsDTO deliveryNotesDetails;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "request_destroy_details")
    private RequestQRDestroyDetailsDTO requestDestroyDetails;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "resolve_issue_details")
    private ResolveIssueDetailsDTO resolveIssueDetails;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "cancel_details")
    private CancelReasonDetailsDTO cancelReasonDetails;

    @Column(name = "order_request_status")
    private String orderRequestStatus;

    @Column(name = "is_gri")
    private Boolean isGRI;

    @Column(name = "is_sticker_received")
    private Boolean isStickerReceived;

    @Column(name = "gri_date")
    private LocalDateTime griDate;

    @Column(name = "sticker_received_date")
    private LocalDateTime stickerReceivedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
