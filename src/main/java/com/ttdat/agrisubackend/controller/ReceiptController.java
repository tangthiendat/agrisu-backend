package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping
    public ResponseEntity<ReceiptDTO> addReceipt(@RequestBody ReceiptDTO receiptDTO){
        return ResponseEntity.ok(receiptService.add(receiptDTO));
    }

}
