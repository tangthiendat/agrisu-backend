package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.service.ReceiptServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/receipts")
public class ReceiptController {

    private final ReceiptServiceImpl receiptServiceImpl;

    @PostMapping
    public ResponseEntity<ReceiptDTO> addReceipt(@RequestBody ReceiptDTO receiptDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(receiptServiceImpl.add(receiptDTO));
    }

}
