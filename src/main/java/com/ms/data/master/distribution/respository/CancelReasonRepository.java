package com.ms.data.master.distribution.respository;

import com.ms.data.master.distribution.model.CancelReason;
import com.ms.data.master.distribution.model.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CancelReasonRepository extends JpaRepository<CancelReason, UUID>, JpaSpecificationExecutor<CancelReason> {
}
