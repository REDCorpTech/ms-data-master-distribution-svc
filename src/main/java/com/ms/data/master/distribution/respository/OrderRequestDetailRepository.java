package com.ms.data.master.distribution.respository;

import com.ms.data.master.distribution.model.OrderRequest;
import com.ms.data.master.distribution.model.OrderRequestDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRequestDetailRepository extends JpaRepository<OrderRequestDetail, UUID> {
}
