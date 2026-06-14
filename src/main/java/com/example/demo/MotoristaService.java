package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MotoristaService {

    public List<Motorista> filtrarEOrdenarMotoristas() {
        List<Motorista> motoristas = getMotoristasDaEmpresa();

        return motoristas.stream()
                .filter(Motorista::isCnhAtiva)
                // Novo filtro: Extrai o Optional do seguro, avalia se está ativo e retorna false se estiver vazio
                .filter(m -> m.getSeguro()
                              .map(Seguro::isAtivo)
                              .orElse(false))
                .sorted(Comparator.comparingInt(Motorista::getAnosEmpresa))
                .toList();
    }

    private List<Motorista> getMotoristasDaEmpresa() {
        return new ArrayList<>();
    }
}

