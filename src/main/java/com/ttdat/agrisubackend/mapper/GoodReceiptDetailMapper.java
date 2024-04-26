package com.ttdat.agrisubackend.mapper;

import com.ttdat.agrisubackend.dto.GoodReceiptDetailDTO;
import com.ttdat.agrisubackend.entity.GoodReceiptDetail;
import org.springframework.stereotype.Component;

@Component
public class GoodReceiptDetailMapper {
    private final ProductMapper productMapper;
    private final UnitMapper unitMapper;

    public GoodReceiptDetailMapper(ProductMapper productMapper, UnitMapper unitMapper) {
        this.productMapper = productMapper;
        this.unitMapper = unitMapper;
    }

    public GoodReceiptDetailDTO toDTO(GoodReceiptDetail goodReceiptDetail) {
        GoodReceiptDetailDTO goodReceiptDetailDTO = new GoodReceiptDetailDTO();
        goodReceiptDetailDTO.setId(goodReceiptDetail.getId());
        goodReceiptDetailDTO.setProduct(productMapper.toDTO(goodReceiptDetail.getProduct()));
        goodReceiptDetailDTO.setUnit(unitMapper.toDTO(goodReceiptDetail.getUnit()));
        goodReceiptDetailDTO.setUnitPrice(goodReceiptDetail.getUnitPrice());
        goodReceiptDetailDTO.setQuantity(goodReceiptDetail.getQuantity());
        return goodReceiptDetailDTO;
    }

    public GoodReceiptDetail toGoodReceiptDetail(GoodReceiptDetailDTO goodReceiptDetailDTO) {
        GoodReceiptDetail goodReceiptDetail = new GoodReceiptDetail();
        goodReceiptDetail.setId(goodReceiptDetailDTO.getId());
        goodReceiptDetail.setProduct(productMapper.toProduct(goodReceiptDetailDTO.getProduct()));
        goodReceiptDetail.setUnit(unitMapper.toUnit(goodReceiptDetailDTO.getUnit()));
        goodReceiptDetail.setUnitPrice(goodReceiptDetailDTO.getUnitPrice());
        goodReceiptDetail.setQuantity(goodReceiptDetailDTO.getQuantity());
        return goodReceiptDetail;
    }
}
