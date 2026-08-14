package com.example.demo.service.strategy;

public class CalculoInterno implements CalculoEstrategia {
    @Override public double calcular(int volume) { return volume * 39.00; }
}
