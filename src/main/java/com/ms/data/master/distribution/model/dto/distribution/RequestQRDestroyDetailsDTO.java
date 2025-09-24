package com.ms.data.master.distribution.model.dto.distribution;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestQRDestroyDetailsDTO {
    private UUID id;
    private String brandId;
    private String requestDestroyStatusName;
    private String requestDestroyRangeFrom;
    private String requestDestroyRangeTo;
    private String requestDestroyNote;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
