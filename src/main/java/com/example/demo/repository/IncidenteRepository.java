package com.example.demo.repository;

import com.example.demo.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

    @Query(value = "SELECT * FROM tbl_incidentes WHERE severidade = :severidade AND data_hora_inicio BETWEEN :inicio AND :fim", nativeQuery = true)
    List<Incidente> buscarCrisesOtimizadas(@Param("severidade") String severidade, 
                                           @Param("inicio") LocalDateTime inicio, 
                                           @Param("fim") LocalDateTime fim);
}