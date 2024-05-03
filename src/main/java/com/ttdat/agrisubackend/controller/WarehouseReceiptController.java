package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.service.WarehouseReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/warehouse-receipts")
public class WarehouseReceiptController {

    private final WarehouseReceiptService warehouseReceiptService;

    @PostMapping
    public ResponseEntity<WarehouseReceiptDTO> addGoodReceipt(@RequestBody WarehouseReceiptDTO warehouseReceiptDTO) {
        return ResponseEntity.ok(warehouseReceiptService.add(warehouseReceiptDTO));
    }

}
