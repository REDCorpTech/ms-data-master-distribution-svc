package com.ms.data.master.distribution.service;

import com.ms.data.master.distribution.model.DeliveryNote;
import com.ms.data.master.distribution.model.dto.distribution.DeliveryNoteDetailsDTO;
import com.ms.data.master.distribution.model.dto.distribution.DeliveryNoteDetailsDTO;
import com.ms.data.master.distribution.model.dto.response.PageResponse;
import com.ms.data.master.distribution.model.mapper.DeliveryNoteMapper;
import com.ms.data.master.distribution.respository.CancelReasonRepository;
import com.ms.data.master.distribution.respository.DeliveryNoteRepository;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DeliveryNoteService {

    private final DeliveryNoteRepository deliveryNoteRepository;

    public PageResponse<DeliveryNoteDetailsDTO> getAllService(Integer pageableSize, Integer pageablePage, Sort sorting, DeliveryNoteDetailsDTO deliveryNoteDetailsDTO)
    {
        return
                new PageResponse<>(
                        getAllFromRepository(pageableSize, pageablePage, sorting, deliveryNoteDetailsDTO)
                                .getContent()
                                .stream()
                                .map(DeliveryNoteMapper.INSTANCE::toDTO)
                                .collect(Collectors.toList()),
                        getAllFromRepository(pageableSize, pageablePage, sorting, deliveryNoteDetailsDTO).getTotalElements(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, deliveryNoteDetailsDTO).getSize(),
                        getAllFromRepository(pageableSize, pageablePage, sorting, deliveryNoteDetailsDTO).getNumber() + 1

                );
    }

    public DeliveryNoteDetailsDTO getIdService(UUID id) {
        return DeliveryNoteMapper.INSTANCE.toDTO(getIdFromRepository(id));
    }

    @Transactional
    public DeliveryNoteDetailsDTO updateService(UUID id, DeliveryNoteDetailsDTO deliveryNoteDetailsDTO) {
        return DeliveryNoteMapper.INSTANCE.toDTO(
                deliveryNoteRepository.save(updateEntityFromDTO(getIdFromRepository(id), deliveryNoteDetailsDTO))
        );
    }

    public void deleteService(UUID id) {
        deleteFromRepository(id);
    }

    private Page<DeliveryNote> getAllFromRepository(Integer pageableSize, Integer pageablePage, Sort sorting, DeliveryNoteDetailsDTO deliveryNoteDetailsDTO) {
        return deliveryNoteRepository.findAll(buildSpecification(deliveryNoteDetailsDTO), PageRequest.of(pageablePage, pageableSize, sorting));
    }

    private DeliveryNote getIdFromRepository(UUID id) {
        return deliveryNoteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cancel Reason not found for id: " + id));
    }

    private void deleteFromRepository(UUID id) {
        deliveryNoteRepository.deleteById(id);
    }

    private DeliveryNote updateEntityFromDTO(DeliveryNote cancelReason, DeliveryNoteDetailsDTO deliveryNoteDetailsDTO) {
        DeliveryNoteMapper.INSTANCE.updateFromDTOToEntity(deliveryNoteDetailsDTO, cancelReason);
        cancelReason.setUpdatedAt(LocalDateTime.now());
        cancelReason.setUpdatedBy(deliveryNoteDetailsDTO.getUpdatedBy());
        return cancelReason;
    }

    private Specification<DeliveryNote> buildSpecification(DeliveryNoteDetailsDTO dto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), dto.getId()));
            }

            if (dto.getThirdPlName() != null && !dto.getThirdPlName().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("thirdPlName")),
                        dto.getThirdPlName().toLowerCase()
                ));
            }

            if (dto.getVehicleType() != null && !dto.getVehicleType().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("vehicleType")),
                        dto.getVehicleType().toLowerCase()
                ));
            }

            if (dto.getCourierName() != null && !dto.getCourierName().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("courierName")),
                        dto.getCourierName().toLowerCase()
                ));
            }

            if (dto.getLicencePlate() != null && !dto.getLicencePlate().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("licencePlate")),
                        dto.getLicencePlate().toLowerCase()
                ));
            }

            if (dto.getAirwayBill() != null && !dto.getAirwayBill().isEmpty()) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("airwayBill")),
                        dto.getAirwayBill().toLowerCase()
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
