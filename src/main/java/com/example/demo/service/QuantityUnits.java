package com.example.demo.service;

public enum QuantityUnits {
    FEET(0.0,12.0, Quantity.Length),
    INCH(0.0,1.0, Quantity.Length),
    YARD(0.0,36.0, Quantity.Length),
    CM(0.0,0.4, Quantity.Length),

    ML(0.0,0.001, Quantity.Volume),
    LITRE(0.0,1, Quantity.Volume),
    GALLON(0.0,3.78, Quantity.Volume),

    GRAM(0.0,0.001, Quantity.Weight),
    KG(0.0,1.0, Quantity.Weight),
    TONNE(0.0,1000.0, Quantity.Weight),

    FAHRENHEIT(0.0,1.0, Quantity.Temperature),
    CELSIUS(32.0,1.8, Quantity.Temperature);

    public double additionConstant;
    double baseUnitConversion;
    Quantity quantity;

    QuantityUnits(double additionConstant, double baseUnitConversion, Quantity quantity) {
        this.additionConstant = additionConstant;
        this.baseUnitConversion = baseUnitConversion;
        this.quantity = quantity;
    }
}
