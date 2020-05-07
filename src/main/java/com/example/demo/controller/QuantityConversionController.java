package com.example.demo.controller;

import com.example.demo.model.DTO;
import com.example.demo.service.Quantity;
import com.example.demo.service.QuantityConvService;
import com.example.demo.service.QuantityUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class QuantityConversionController {
    @Autowired
    QuantityConvService quantityConvService;
    @GetMapping("/quantity")
    public ResponseEntity getQuantity() {
        return new ResponseEntity(quantityConvService.getQuantity(), HttpStatus.OK);
    }

    @GetMapping("/quantity/{quantityUnits}")
    public ResponseEntity getQuantityUnits(@PathVariable Quantity quantityUnits) {
        return new ResponseEntity(quantityConvService.getQuantityUnits(quantityUnits), HttpStatus.OK);
    }

    @PostMapping("/quantity/conversion/{conversionUnit}")
    public ResponseEntity convertQuantityToUnit(@RequestBody DTO Dto, @PathVariable QuantityUnits conversionUnit) {
        return new ResponseEntity(quantityConvService.convertQuantityToUnit(Dto, conversionUnit), HttpStatus.OK);
    }

}
