package com.example.demo.service.strategy;

public class CalculoBpo implements CalculoEstrategia {
    public double calcular(int volume) { return volume * 11.50; }
}
