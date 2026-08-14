package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_incidentes")
public class Incidente extends EntidadeBase {

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 2)
    private String severidade; // P1, P2, P3, P4

    @Column(name = "data_hora_inicio", nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_termino")
    private LocalDateTime dataHoraTermino;

    @Column(name = "operador_responsavel_hash", nullable = false)
    private String operadorResponsavelHash;

    @Column(name = "vol_automatizado") private int volumeAutomatizado;
    @Column(name = "vol_bpo") private int volumeBpo;
    @Column(name = "vol_interno") private int volumeInterno;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getSeveridade() { return severidade; }
    public void setSeveridade(String sev) { this.severidade = sev; }
    public LocalDateTime getDataHoraInicio() { return dataHoraInicio; }
    public void setDataHoraInicio(LocalDateTime inicio) { this.dataHoraInicio = inicio; }
    public LocalDateTime getDataHoraTermino() { return dataHoraTermino; }
    public void setDataHoraTermino(LocalDateTime fim) { this.dataHoraTermino = fim; }
    public int getVolumeAutomatizado() { return volumeAutomatizado; }
    public void setVolumeAutomatizado(int v) { this.volumeAutomatizado = v; }
    public int getVolumeBpo() { return volumeBpo; }
    public void setVolumeBpo(int v) { this.volumeBpo = v; }
    public int getVolumeInterno() { return volumeInterno; }
    public void setVolumeInterno(int v) { this.volumeInterno = v; }
    public String getOperadorResponsavelHash() { return operadorResponsavelHash; }
    public void setOperadorResponsavelHash(String hash) { this.operadorResponsavelHash = hash; }
}