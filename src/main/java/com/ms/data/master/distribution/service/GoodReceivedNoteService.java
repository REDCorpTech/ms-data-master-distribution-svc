package com.ms.data.master.distribution.service;

import com.ms.data.master.distribution.model.*;
import com.ms.data.master.distribution.model.dto.distribution.GoodReceivedNoteDetailsDTO;
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
public class GoodReceivedNoteService {
    private final GoodsReceivedNotesRepository goodsReceivedNotesRepository;

    public PageResponse<GoodReceivedNoteDetailsDTO> getAllService(Integer pageableSize, Integer pageablePage, Sort sorting, GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO)
    {
        return
                new PageResponse<>(
                        getAllFromRepository(pageableSize, pageablePage, sorting, goodReceivedNoteDetailsDTO)
                                .getContent()
                                .stream()
                                .map(GoodReceivedNoteDetailMapper.INSTANCE::toDTO)
                                .collect(Collectors.toList()),
                        getAllFromRepository(pageableSize, pageablePage, sorting, goodReceivedNoteDetailsDTO).getTotalElements(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, goodReceivedNoteDetailsDTO).getSize(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, goodReceivedNoteDetailsDTO).getNumber() + 1

                );
    }

    public GoodReceivedNoteDetailsDTO getIdService(UUID id) {
        return GoodReceivedNoteDetailMapper.INSTANCE.toDTO(getIdFromRepository(id));
    }

//    public GoodReceivedNoteDetailsDTO getGoodsReceivedNotesStatusService(String orderRequestStatus) {
//        return GoodReceivedNoteDetailMapper.INSTANCE.toDTO(getGoodsReceivedNotesStatusFromRepository(orderRequestStatus));
//    }

    @Transactional
    public GoodReceivedNoteDetailsDTO updateService(UUID id, GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO) {
        return GoodReceivedNoteDetailMapper.INSTANCE.toDTO(
                goodsReceivedNotesRepository.save(updateEntityFromDTO(getIdFromRepository(id), goodReceivedNoteDetailsDTO))
        );
    }

    public void deleteService(UUID id) {
        deleteFromRepository(id);
    }

    private Page<GoodsReceivedNotes> getAllFromRepository(Integer pageableSize, Integer pageablePage, Sort sorting, GoodReceivedNoteDetailsDTO goodReceivedNoteDetailsDTO) {
        return goodsReceivedNotesRepository.findAll(buildSpecification(goodReceivedNoteDetailsDTO), PageRequest.of(pageablePage, pageableSize, sorting));
    }

    private GoodsReceivedNotes getIdFromRepository(UUID id) {
        return goodsReceivedNotesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Request not found for id: " + id));
    }

//    private GoodsReceivedNotes getGoodsReceivedNotesStatusFromRepository(String orderRequestStatus) {
//        return goodsReceivedNotesRepository.findAllByGoodsReceivedNotesStatus(orderRequestStatus).stream()
//                .findFirst()
//                .orElseThrow(() -> new EntityNotFoundException("Order Request not found for order request status: " + orderRequestStatus));
//    }

    private void deleteFromRepository(UUID id) {
        goodsReceivedNotesRepository.deleteById(id);
    }

    private GoodsReceivedNotes updateEntityFromDTO(GoodsReceivedNotes existing, GoodReceivedNoteDetailsDTO dto) {
        GoodReceivedNoteDetailMapper.INSTANCE.updateFromDTOToEntity(dto, existing);
        existing.setUpdatedAt(LocalDateTime.now());
        existing.setUpdatedBy(dto.getUpdatedBy());
        return existing;
    }

    private Specification<GoodsReceivedNotes> buildSpecification(GoodReceivedNoteDetailsDTO dto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), dto.getId()));
            }

            if (dto.getRecievedBy() != null && !dto.getRecievedBy().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("recievedBy")),
                        dto.getRecievedBy().toLowerCase()
                ));
            }

            if (dto.getConfirmedBy() != null && !dto.getConfirmedBy().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("confirmedBy")),
                        dto.getConfirmedBy().toLowerCase()
                ));
            }

            if (dto.getReceivedDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("receivedDate"), dto.getReceivedDate()));
            }

            if (dto.getReceivedQrRangeFrom() != null && !dto.getReceivedQrRangeFrom().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("receivedQrRangeFrom"), dto.getReceivedQrRangeFrom()));
            }

            if (dto.getReceivedQrRangeTo() != null && !dto.getReceivedQrRangeTo().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("receivedQrRangeTo"), dto.getReceivedQrRangeTo()));
            }

            if (dto.getReceivedQrQty() != null) {
                predicates.add(criteriaBuilder.equal(root.get("receivedQrQty"), dto.getReceivedQrQty()));
            }

            if (dto.getRecievedQrListId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("recievedQrListId"), dto.getRecievedQrListId()));
            }

            if (dto.getReceivedStatusId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("receivedStatusId"), dto.getReceivedStatusId()));
            }

            if (dto.getAdditionalInformation() != null && !dto.getAdditionalInformation().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("additionalInformation")),
                        "%" + dto.getAdditionalInformation().toLowerCase() + "%"
                ));
            }

            if (dto.getCreatedBy() != null && !dto.getCreatedBy().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("createdBy")),
                        dto.getCreatedBy().toLowerCase()
                ));
            }

            if (dto.getCreatedAt() != null) {
                predicates.add(criteriaBuilder.equal(root.get("createdAt"), dto.getCreatedAt()));
            }

            if (dto.getUpdatedBy() != null && !dto.getUpdatedBy().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("updatedBy")),
                        dto.getUpdatedBy().toLowerCase()
                ));
            }

            if (dto.getUpdatedAt() != null) {
                predicates.add(criteriaBuilder.equal(root.get("updatedAt"), dto.getUpdatedAt()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }


}
