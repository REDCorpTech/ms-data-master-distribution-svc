//package com.ms.data.master.distribution.controller;
//
//import com.ms.data.master.distribution.exception.AccountExceptionHandler;
//import com.ms.data.master.distribution.model.dto.distribution.OrderRequestDTO;
//import com.ms.data.master.distribution.model.dto.response.PageResponse;
//import com.ms.data.master.distribution.service.OrderRequestService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.SortDefault;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("${endpoint.cancel-reason.base}")
//@RequiredArgsConstructor
//@Slf4j
//public class DeliveryNoteController {
//    private final OrderRequestService orderRequestService;
//
//    @Value("${common.pageable.size}")
//    private Integer pageableSize;
//
//    @Value("${common.pageable.page}")
//    private Integer pageablePage;
//
//    @Value("${common.sorting}")
//    private String sortingPage;
//
//    @GetMapping(value = "${endpoint.cancel-reason.get-all}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PageResponse<OrderRequestDTO>> getAllOrderRequests(
//            @RequestParam(value = "pageableSize", required = false) Integer defaultPageableSize,
//            @RequestParam(value = "pageablePage", required = false) Integer defaultPageablePage,
//            @ModelAttribute OrderRequestDTO orderRequestDTO,
//            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Sort sorting) throws AccountExceptionHandler {
//
//        return ResponseEntity.ok(orderRequestService.getAllService(
//                Optional.ofNullable(defaultPageableSize).filter(size -> size > 0).orElse(pageableSize),
//                Optional.ofNullable(defaultPageablePage).filter(page -> page >= 0).orElse(pageablePage),
//                Optional.ofNullable(sorting).orElse(Sort.by(Sort.Direction.fromString(sortingPage), "id")),
//                orderRequestDTO
//        ));
//    }
//
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<OrderRequestDTO> createOrderRequests(@RequestBody OrderRequestDTO OrderRequestDTO) {
//        return ResponseEntity.ok(orderRequestService.createService(OrderRequestDTO));
//    }
//
//    @GetMapping(value = "${endpoint.cancel-reason.get-by-id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<OrderRequestDTO> getOrderRequests(@PathVariable UUID id) {
//        return ResponseEntity.ok(orderRequestService.getIdService(id));
//    }
//
//    @PutMapping( value = "${endpoint.cancel-reason.update}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<OrderRequestDTO> updateOrderRequests(@PathVariable UUID id, @RequestBody OrderRequestDTO orderRequestDTO) {
//        return ResponseEntity.ok(orderRequestService.updateService(id, orderRequestDTO));
//    }
//
//    @DeleteMapping(value = "${endpoint.cancel-reason.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> deleteOrderRequests(@PathVariable UUID id) {
//        orderRequestService.deleteService(id);
//        return ResponseEntity.ok().build();
//    }
//}
