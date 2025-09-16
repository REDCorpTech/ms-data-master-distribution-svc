package com.ms.data.master.distribution.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "endpoint.order-request-detail")
@Getter
@Setter
public class OrderRequestDetailEndpointProperties {
    private String base;
    private String getAll;
    private String getById;
    private String update;
    private String delete;
}
