package com.example.demo;

public class Seguro {
    private boolean ativo;

    public Seguro() {}

    public Seguro(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
