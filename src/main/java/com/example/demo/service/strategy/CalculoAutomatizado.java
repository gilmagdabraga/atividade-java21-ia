package com.example.demo.service.strategy;

public class CalculoAutomatizado implements CalculoEstrategia {
    @Override public double calcular(int volume) { return volume * 0.55; }
}
