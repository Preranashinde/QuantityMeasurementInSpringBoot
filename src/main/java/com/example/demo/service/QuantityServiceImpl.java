package com.example.demo.service;

import com.example.demo.model.DTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class QuantityServiceImpl implements QuantityConvService{
    @Override
    public List<String> getQuantity() {
        return Stream.of(Quantity.values()).map(Quantity::name)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuantityUnits> getQuantityUnits(Quantity quantity) {
        return Arrays.stream(QuantityUnits.values()).filter(unit ->
                unit.quantity.equals(quantity)).collect(Collectors.toList());
    }

    @Override
    public DTO convertQuantityToUnit(DTO Dto, QuantityUnits conversionUnit) {
        double Value = Dto.getValue() * Dto.getQuantityUnits().baseUnitConversion+
                Dto.getQuantityUnits().additionConstant;
        Value = (Value - conversionUnit.additionConstant) / conversionUnit.baseUnitConversion;
        return new DTO(Value, conversionUnit);
    }
}

