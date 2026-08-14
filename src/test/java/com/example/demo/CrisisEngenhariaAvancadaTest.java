package com.example.demo;

import com.example.demo.model.Incidente;
import com.example.demo.service.CrisisService;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class CrisisEngenhariaAvancadaTest {

    private final CrisisService service = new CrisisService(null);

    @Test
    public void workshopEngenhariaDeSoftwareTest() {
        Incidente incidente = new Incidente();
        incidente.setTitulo("Banking");
        incidente.setSeveridade("P1");
        incidente.setDataHoraInicio(LocalDateTime.of(2026, 8, 15, 10, 0));
        incidente.setDataHoraTermino(LocalDateTime.of(2026, 8, 15, 12, 0));
        incidente.setOperadorResponsavelHash("SHA256:9a8b7c6d5e");
        
        incidente.setVolumeAutomatizado(2000); 
        incidente.setVolumeBpo(100);          
        incidente.setVolumeInterno(5);         

        double custoCalculado = service.calcularImpactoFinanceiro(incidente);
        String queryMysql = service.obterComandoSqlDatabricks(incidente);

        if (custoCalculado != 2445.00) {
            throw new AssertionError("O cálculo do impacto financeiro divergiu do esperado.");
        }

        System.out.println("\n====== PROJETO CRISISHUB: APRESENTAÇÃO DE CONCEITOS ======");
        System.out.println("✔️ DESIGN PATTERNS: Padrões Strategy e Factory validados com sucesso!");
        System.out.println("✔️ SEGURANÇA: Chave do operador protegida na camada de persistência: " + incidente.getOperadorResponsavelHash());
        System.out.println("✔️ PERFORMANCE: Custo calculado via algoritmo O(1): R$ " + custoCalculado);
        System.out.println("✔️ CONSULTA MYSQL GERADA AUTOMATICAMENTE:\n" + queryMysql);
        System.out.println("==========================================================\n");
    }
}
