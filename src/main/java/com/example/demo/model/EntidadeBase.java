package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Version // OTIMIZAÇÃO: Bloqueio Otimista contra escrita simultânea
    private Long versao;

    @PrePersist
    protected void onCreate() { this.dataCadastro = LocalDateTime.now(); }

    public Long getId() { return id; }
    public Long getVersao() { return versao; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
}