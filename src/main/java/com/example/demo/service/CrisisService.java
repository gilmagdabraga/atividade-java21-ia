package com.example.demo.service;

import com.example.demo.model.Incidente;
import com.example.demo.repository.IncidenteRepository;
import com.example.demo.service.factory.CalculoFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.format.DateTimeFormatter;

@Service
public class CrisisService {

    private final IncidenteRepository repository;

    // Construtor explícito para evitar problemas de injeção no ecossistema Spring
    public CrisisService(IncidenteRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Incidente registrarCriseConsolidada(Incidente incidente) {
        if (incidente.getDataHoraTermino() != null && 
            incidente.getDataHoraTermino().isBefore(incidente.getDataHoraInicio())) {
            throw new IllegalArgumentException("Inconsistência Temporal: Término incorreto.");
        }
        return repository.save(incidente);
    }

    public double calcularImpactoFinanceiro(Incidente incidente) {
        double total = 0;
        total += CalculoFactory.obterEstrategia("AUTOMATIZADO").calcular(incidente.getVolumeAutomatizado());
        total += CalculoFactory.obterEstrategia("BPO").calcular(incidente.getVolumeBpo());
        total += CalculoFactory.obterEstrategia("INTERNO").calcular(incidente.getVolumeInterno());
        return total;
    }

    public String obterComandoSqlDatabricks(Incidente incidente) {
        DateTimeFormatter formatoMysql = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "SELECT canal_atendimento, COUNT(1) AS total_chamados " +
               "FROM db_atendimento.chamados_picpay " +
               "WHERE produto = '" + incidente.getTitulo().replaceAll("[';]", "") + "' " + 
               "AND data_criacao BETWEEN '" + incidente.getDataHoraInicio().format(formatoMysql) + "' " +
               "AND '" + (incidente.getDataHoraTermino() != null ? incidente.getDataHoraTermino().format(formatoMysql) : "NOW()") + "' " +
               "GROUP BY canal_atendimento;";
    }
}