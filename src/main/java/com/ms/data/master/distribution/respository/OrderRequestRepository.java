package com.ms.data.master.distribution.respository;

import com.ms.data.master.distribution.model.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, UUID>, JpaSpecificationExecutor<OrderRequest> {
}
