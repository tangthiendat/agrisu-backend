package com.ttdat.agrisubackend.controller;

import com.ttdat.agrisubackend.dto.GoodReceiptDTO;
import com.ttdat.agrisubackend.service.GoodReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/good-receipts")
public class GoodReceiptController {
    private final GoodReceiptService goodReceiptService;

    public GoodReceiptController(GoodReceiptService goodReceiptService) {
        this.goodReceiptService = goodReceiptService;
    }

    @PostMapping
    public ResponseEntity<GoodReceiptDTO> addGoodReceipt(@RequestBody GoodReceiptDTO goodReceiptDTO) {
        return ResponseEntity.ok(goodReceiptService.add(goodReceiptDTO));
    }

}
