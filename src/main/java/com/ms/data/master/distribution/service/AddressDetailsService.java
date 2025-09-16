package com.ms.data.master.distribution.service;

import com.ms.data.master.distribution.respository.AddressDetailsRepository;
import com.ms.data.master.distribution.respository.OrderRequestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AddressDetailsService {
    private final OrderRequestRepository orderRequestRepository;
    private final AddressDetailsRepository addressDetailsRepository;
}
