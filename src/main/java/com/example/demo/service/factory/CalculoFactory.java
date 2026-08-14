package com.example.demo.service.factory;
import com.example.demo.service.strategy.*;
import java.util.HashMap;
import java.util.Map;

public class CalculoFactory {
    private static final Map<String, CalculoEstrategia> estrategias = new HashMap<>();

    static {
        estrategias.put("AUTOMATIZADO", new CalculoAutomatizado());
        estrategias.put("BPO", new CalculoBpo());
        estrategias.put("INTERNO", new CalculoInterno());
    }

    public static CalculoEstrategia obterEstrategia(String tipoCanal) {
        CalculoEstrategia estrategia = estrategias.get(tipoCanal.toUpperCase());
        if (estrategia == null) {
            throw new IllegalArgumentException("Canal de atendimento não suportado.");
        }
        return estrategia;
    }
}