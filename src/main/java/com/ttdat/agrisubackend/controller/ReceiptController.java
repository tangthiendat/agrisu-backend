package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.ReceiptDTO;
import com.ttdat.agrisubackend.service.ReceiptService;
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
@RequestMapping("/v1/receipts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReceiptController {

    ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<ReceiptDTO> addReceipt(@RequestBody ReceiptDTO receiptDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(receiptService.add(receiptDTO));
    }

}
