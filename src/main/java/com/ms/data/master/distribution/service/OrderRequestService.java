package com.ms.data.master.distribution.service;

import com.ms.data.master.distribution.model.*;
import com.ms.data.master.distribution.model.dto.distribution.OrderRequestDTO;
import com.ms.data.master.distribution.model.dto.distribution.OrderRequestDetailsDTO;
import com.ms.data.master.distribution.model.dto.response.PageResponse;
import com.ms.data.master.distribution.model.mapper.*;
import com.ms.data.master.distribution.respository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderRequestService {
    private final OrderRequestRepository orderRequestRepository;
    private final AddressDetailsRepository addressDetailsRepository;
    private final DeliveryNoteRepository deliveryNoteRepository;
    private final GoodsReceivedNotesRepository goodsReceivedNotesRepository;
    private final QRListRepository qrListRepository;
    private final RequestQRDestroyRepository requestQRDestroyRepository;
    private final ResolveIssueRepository resolveIssueRepository;
    private final CancelReasonRepository cancelReasonRepository;

    public PageResponse<OrderRequestDTO> getAllService(Integer pageableSize, Integer pageablePage, Sort sorting, OrderRequestDTO orderRequestDTO)
    {
        return
                new PageResponse<>(
                        getAllFromRepository(pageableSize, pageablePage, sorting, orderRequestDTO)
                                .getContent()
                                .stream()
                                .map(OrderRequestMapper.INSTANCE::toDTO)
                                .collect(Collectors.toList()),
                        getAllFromRepository(pageableSize, pageablePage, sorting, orderRequestDTO).getTotalElements(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, orderRequestDTO).getSize(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, orderRequestDTO).getNumber() + 1

                );
    }

    public OrderRequestDTO getIdService(UUID id) {
        return OrderRequestMapper.INSTANCE.toDTO(getIdFromRepository(id));
    }

    @Transactional
    public OrderRequestDTO createService(OrderRequestDTO dto) {
        // 1. Save OrderRequest
        OrderRequest savedOrder = orderRequestRepository.save(OrderRequestMapper.INSTANCE.toEntity(dto));

        UUID qrListId;
        QRList savedQrList = Optional.ofNullable(dto.getOrderRequestDetails())
                .map(OrderRequestDetailsDTO::getQrListDetails)
                .map(qrListDTO -> {
                    QRList qrList = QRListDetailMapper.INSTANCE.toEntity(qrListDTO)
                            .setOrderRequestId(savedOrder.getId());
                    return qrListRepository.save(qrList);
                }).orElse(null);

        if (savedQrList != null) {
            qrListId = savedQrList.getId();
            dto.getOrderRequestDetails().setQrListDetails(
                    QRListDetailMapper.INSTANCE.toDTO(savedQrList)
            );
        } else {
            qrListId = null;
        }

        // 1. Save QRListDetails (if present)
        Optional.ofNullable(dto.getOrderRequestDetails())
                .map(OrderRequestDetailsDTO::getQrListDetails)
                .ifPresent(qrListDTO -> {
                    QRList qrList = QRListDetailMapper.INSTANCE.toEntity(qrListDTO);
                    qrList.setOrderRequestId(savedOrder.getId()); // foreign key
                    qrListRepository.save(qrList);
                });

        // 2. Save AddressDetails (if present)
        Optional.ofNullable(dto.getOrderRequestDetails())
                .map(OrderRequestDetailsDTO::getAddressDetails)
                .ifPresent(addressDTO -> {
                    AddressDetails address = AddressDetailMapper.INSTANCE.toEntity(addressDTO)
                            .setOrderRequestId(savedOrder.getId())
                            .setQrListId(qrListId);
                    AddressDetails savedAddress = addressDetailsRepository.save(address);
                    // Update DTO with saved ID
                    dto.getOrderRequestDetails().setAddressDetails(
                            AddressDetailMapper.INSTANCE.toDTO(savedAddress)
                    );
                });

        // 3. Save DeliveryNoteDetails (if present)
        Optional.ofNullable(dto.getDeliveryNotesDetails())
                .ifPresent(deliveryNoteDTO -> {
                    DeliveryNote deliveryNote = DeliveryNoteMapper.INSTANCE.toEntity(deliveryNoteDTO);
                    deliveryNote.setId(UUID.randomUUID());
                    deliveryNote.setOrderRequestId(savedOrder.getId());
                    deliveryNoteRepository.save(deliveryNote);
                });

        // 4. Save GoodReceivedNoteDetails (if present)
        Optional.ofNullable(dto.getGoodReceivedNoteDetails())
                .ifPresent(grnDTO -> {
                    GoodsReceivedNotes grn = GoodReceivedNoteDetailMapper.INSTANCE.toEntity(grnDTO);
                    grn.setId(UUID.randomUUID());
                    grn.setOrderRequestId(savedOrder.getId());
                    goodsReceivedNotesRepository.save(grn);
                });

        // 5. Save RequestDestroyDetails (if present)
        Optional.ofNullable(dto.getRequestDestroyDetails())
                .ifPresent(reqDestroyDTO -> {
                    RequestQRDestroy destroy = RequestQRDestroyDetailMapper.INSTANCE.toEntity(reqDestroyDTO);
                    destroy.setId(UUID.randomUUID());
                    destroy.setOrderRequestId(savedOrder.getId());
                    requestQRDestroyRepository.save(destroy);
                });

//        // 6. Save ResolveIssueDetails (if present)
        Optional.ofNullable(dto.getResolveIssueDetails())
                .ifPresent(resolveDTO -> {
                    ResolveIssue resolve = ResolveIssueMapper.INSTANCE.toEntity(resolveDTO);
                    resolve.setId(UUID.randomUUID());
                    resolve.setOrderRequestId(savedOrder.getId());
                    resolveIssueRepository.save(resolve);
                });
//
//        // 7. Save CancelDetails (if present)
        Optional.ofNullable(dto.getCancelReasonDetails())
                .ifPresent(cancelDTO -> {
                    CancelReason cancel = CancelReasonMapper.INSTANCE.toEntity(cancelDTO);
                    cancel.setId(UUID.randomUUID());
                    cancel.setOrderRequestId(savedOrder.getId());
                    cancelReasonRepository.save(cancel);
                });

        // 8. Return final DTO
        return OrderRequestMapper.INSTANCE.toDTO(savedOrder);
    }

    @Transactional
    public OrderRequestDTO updateService(UUID id, OrderRequestDTO orderRequestDTO) {
        return OrderRequestMapper.INSTANCE.toDTO(
                orderRequestRepository.save(updateEntityFromDTO(getIdFromRepository(id), orderRequestDTO))
        );
    }

    public void deleteService(UUID id) {
        deleteFromRepository(id);
    }

    private Page<OrderRequest> getAllFromRepository(Integer pageableSize, Integer pageablePage, Sort sorting, OrderRequestDTO orderRequestDTO) {
        return orderRequestRepository.findAll(buildSpecification(orderRequestDTO), PageRequest.of(pageablePage, pageableSize, sorting));
    }

    private OrderRequest getIdFromRepository(UUID id) {
        return orderRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Request not found for id: " + id));
    }

    private void deleteFromRepository(UUID id) {
        orderRequestRepository.deleteById(id);
    }

    private OrderRequest updateEntityFromDTO(OrderRequest existing, OrderRequestDTO dto) {
        OrderRequestMapper.INSTANCE.updateFromDTOToEntity(dto, existing);
        existing.setUpdatedAt(LocalDateTime.now());
        existing.setUpdatedBy(dto.getUpdatedBy());
        return existing;
    }

    private Specification<OrderRequest> buildSpecification(OrderRequestDTO orderRequestDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (orderRequestDTO.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), orderRequestDTO.getId()));
            }

            if (orderRequestDTO.getCreatedBy() != null && !orderRequestDTO.getCreatedBy().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("createdBy")),
                        orderRequestDTO.getCreatedBy().toLowerCase()
                ));
            }

            if (orderRequestDTO.getIsGRI() != null) {
                predicates.add(criteriaBuilder.equal(root.get("isGRI"), orderRequestDTO.getIsGRI()));
            }
            if (orderRequestDTO.getIsStickerReceived() != null) {
                predicates.add(criteriaBuilder.equal(root.get("isStickerReceived"), orderRequestDTO.getIsStickerReceived()));
            }

            if (orderRequestDTO.getGriDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("griDate"), orderRequestDTO.getGriDate()));
            }

            if (orderRequestDTO.getStickerReceivedDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("stickerReceivedDate"), orderRequestDTO.getStickerReceivedDate()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
