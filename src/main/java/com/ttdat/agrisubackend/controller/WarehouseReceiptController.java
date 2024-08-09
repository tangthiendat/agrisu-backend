package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.service.WarehouseReceiptService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/warehouse-receipts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WarehouseReceiptController {

    WarehouseReceiptService warehouseReceiptService;

    @PostMapping
    public ResponseEntity<WarehouseReceiptDTO> addGoodReceipt(@RequestBody WarehouseReceiptDTO warehouseReceiptDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseReceiptService.add(warehouseReceiptDTO));
    }

}
