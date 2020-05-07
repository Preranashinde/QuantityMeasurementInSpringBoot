package com.example.demo.model;

import com.example.demo.service.QuantityUnits;

public class DTO {
    private double Value;
    private final QuantityUnits quantityUnits;

    public DTO(double VALUE, QuantityUnits quantityUnits) {
        this.Value = Value;
        this.quantityUnits = quantityUnits;
    }

    public double getValue() {
        return Value;
    }

    public QuantityUnits getQuantityUnits() {
        return quantityUnits;
    }
}
