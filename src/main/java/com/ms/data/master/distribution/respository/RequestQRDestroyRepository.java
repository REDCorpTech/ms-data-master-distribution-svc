package com.ms.data.master.distribution.respository;

import com.ms.data.master.distribution.model.RequestQRDestroy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestQRDestroyRepository extends JpaRepository<RequestQRDestroy, UUID> {
}
