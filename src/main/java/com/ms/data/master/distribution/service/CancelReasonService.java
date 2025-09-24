package com.ms.data.master.distribution.service;

import com.ms.data.master.distribution.model.*;
import com.ms.data.master.distribution.model.dto.distribution.CancelReasonDetailsDTO;
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
public class CancelReasonService {

    private final CancelReasonRepository cancelReasonRepository;

    public PageResponse<CancelReasonDetailsDTO> getAllService(Integer pageableSize, Integer pageablePage, Sort sorting, CancelReasonDetailsDTO cancelReasonDetailsDTO)
    {
        return
                new PageResponse<>(
                        getAllFromRepository(pageableSize, pageablePage, sorting, cancelReasonDetailsDTO)
                                .getContent()
                                .stream()
                                .map(CancelReasonMapper.INSTANCE::toDTO)
                                .collect(Collectors.toList()),
                        getAllFromRepository(pageableSize, pageablePage, sorting, cancelReasonDetailsDTO).getTotalElements(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, cancelReasonDetailsDTO).getSize(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, cancelReasonDetailsDTO).getNumber() + 1

                );
    }

    public CancelReasonDetailsDTO getIdService(UUID id) {
        return CancelReasonMapper.INSTANCE.toDTO(getIdFromRepository(id));
    }

    @Transactional
    public CancelReasonDetailsDTO updateService(UUID id, CancelReasonDetailsDTO cancelReasonDetailsDTO) {
        return CancelReasonMapper.INSTANCE.toDTO(
                cancelReasonRepository.save(updateEntityFromDTO(getIdFromRepository(id), cancelReasonDetailsDTO))
        );
    }

    public void deleteService(UUID id) {
        deleteFromRepository(id);
    }

    private Page<CancelReason> getAllFromRepository(Integer pageableSize, Integer pageablePage, Sort sorting, CancelReasonDetailsDTO cancelReasonDetailsDTO) {
        return cancelReasonRepository.findAll(buildSpecification(cancelReasonDetailsDTO), PageRequest.of(pageablePage, pageableSize, sorting));
    }

    private CancelReason getIdFromRepository(UUID id) {
        return cancelReasonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cancel Reason not found for id: " + id));
    }

    private void deleteFromRepository(UUID id) {
        cancelReasonRepository.deleteById(id);
    }

    private CancelReason updateEntityFromDTO(CancelReason cancelReason, CancelReasonDetailsDTO cancelReasonDetailsDTO) {
        CancelReasonMapper.INSTANCE.updateFromDTOToEntity(cancelReasonDetailsDTO, cancelReason);
        cancelReason.setUpdatedAt(LocalDateTime.now());
        cancelReason.setUpdatedBy(cancelReasonDetailsDTO.getUpdatedBy());
        return cancelReason;
    }

    private Specification<CancelReason> buildSpecification(CancelReasonDetailsDTO cancelReasonDetailsDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (cancelReasonDetailsDTO.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), cancelReasonDetailsDTO.getId()));
            }

            if (cancelReasonDetailsDTO.getCreatedBy() != null && !cancelReasonDetailsDTO.getCreatedBy().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("createdBy")),
                        cancelReasonDetailsDTO.getCreatedBy().toLowerCase()
                ));
            }

            if (cancelReasonDetailsDTO.getCancelReason() != null) {
                predicates.add(criteriaBuilder.equal(root.get("cancelReason"), cancelReasonDetailsDTO.getCancelReason()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
