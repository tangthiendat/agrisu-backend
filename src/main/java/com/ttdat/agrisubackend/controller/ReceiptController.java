package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<ReceiptDTO> addReceipt(@RequestBody ReceiptDTO receiptDTO){
        return ResponseEntity.ok(receiptService.add(receiptDTO));
    }

}
