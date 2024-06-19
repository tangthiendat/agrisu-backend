package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.WarehouseReceiptDTO;
import com.ttdat.agrisubackend.service.WarehouseReceiptServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/warehouse-receipts")
public class WarehouseReceiptController {

    private final WarehouseReceiptServiceImpl warehouseReceiptServiceImpl;

    @PostMapping
    public ResponseEntity<WarehouseReceiptDTO> addGoodReceipt(@RequestBody WarehouseReceiptDTO warehouseReceiptDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseReceiptServiceImpl.add(warehouseReceiptDTO));
    }

}
