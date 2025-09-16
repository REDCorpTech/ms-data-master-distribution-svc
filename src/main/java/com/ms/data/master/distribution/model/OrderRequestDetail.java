package com.ms.data.master.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ms.data.master.distribution.model.dto.distribution.AddressDetailsDTO;
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
@Table(name = "t_order_request_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequestDetail {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "address_details")
    private AddressDetailsDTO addressDetail;

    @Column(name = "address")
    private String address;

    @Column(name = "subdistrict")
    private String subdistrict;

    @Column(name = "district")
    private String district;

    @Column(name = "city_regency")
    private String cityRegency;

    @Column(name = "province")
    private String province;

    @Column(name = "rt")
    private String rt;

    @Column(name = "rw")
    private String rw;

    @Column(name = "postcode")
    private String postCode;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
