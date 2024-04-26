package com.ttdat.agrisubackend.service;

import com.ttdat.agrisubackend.dto.GoodReceiptDTO;
import com.ttdat.agrisubackend.entity.GoodReceipt;
import com.ttdat.agrisubackend.entity.GoodReceiptDetail;
import com.ttdat.agrisubackend.mapper.GoodReceiptDetailMapper;
import com.ttdat.agrisubackend.mapper.GoodReceiptMapper;
import com.ttdat.agrisubackend.repository.GoodReceiptDetailRepository;
import com.ttdat.agrisubackend.repository.GoodReceiptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GoodReceiptService {
    private final GoodReceiptRepository goodReceiptRepository;
    private final GoodReceiptMapper goodReceiptMapper;
    private final GoodReceiptDetailRepository goodReceiptDetailRepository;
    private final GoodReceiptDetailMapper goodReceiptDetailMapper;

    public GoodReceiptService(GoodReceiptRepository goodReceiptRepository, GoodReceiptMapper goodReceiptMapper,
                              GoodReceiptDetailRepository goodReceiptDetailRepository, GoodReceiptDetailMapper goodReceiptDetailMapper) {
        this.goodReceiptRepository = goodReceiptRepository;
        this.goodReceiptMapper = goodReceiptMapper;
        this.goodReceiptDetailRepository = goodReceiptDetailRepository;
        this.goodReceiptDetailMapper = goodReceiptDetailMapper;
    }

    @Transactional
    public GoodReceiptDTO add(GoodReceiptDTO goodReceiptDTO) {
        GoodReceipt savedGoodReceipt = goodReceiptRepository.save(goodReceiptMapper.toGoodReceipt(goodReceiptDTO));
        Set<GoodReceiptDetail> goodReceiptDetails = goodReceiptDTO.getGoodReceiptDetails().stream()
                .map(goodReceiptDetailMapper::toGoodReceiptDetail)
                .peek(goodReceiptDetail -> goodReceiptDetail.setGoodReceipt(savedGoodReceipt))
                .collect(Collectors.toSet());
        List<GoodReceiptDetail> savedGoodReceiptDetails = goodReceiptDetailRepository.saveAll(goodReceiptDetails);
        savedGoodReceipt.setGoodReceiptDetails(new HashSet<>(savedGoodReceiptDetails));
        return goodReceiptMapper.toDTO(savedGoodReceipt);
    }
}
