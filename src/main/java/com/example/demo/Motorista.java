package com.example.demo;

import java.util.Optional;

public class Motorista {
    private boolean cnhAtiva;
    private int anosEmpresa;
    private Seguro seguro; // Novo atributo

    public Motorista() {}

    public boolean isCnhAtiva() {
        return cnhAtiva;
    }

    public int getAnosEmpresa() {
        return anosEmpresa;
    }

    // NOVO MÉTODO: Retorna o seguro envelopado em um Optional
    public Optional<Seguro> getSeguro() {
        return Optional.ofNullable(seguro);
    }

    public void setCnhAtiva(boolean cnhAtiva) {
        this.cnhAtiva = cnhAtiva;
    }

    public void setAnosEmpresa(int anosEmpresa) {
        this.anosEmpresa = anosEmpresa;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
