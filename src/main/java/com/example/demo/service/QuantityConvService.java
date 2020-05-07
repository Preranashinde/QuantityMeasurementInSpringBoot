package com.example.demo.service;

import com.example.demo.model.DTO;

import java.util.List;

public interface QuantityConvService {
    List<String> getQuantity();
    List<QuantityUnits> getQuantityUnits(Quantity quantity);
    DTO convertQuantityToUnit(DTO Dto, QuantityUnits conversionUnit);
}
