package com.emanoel.vendedores.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emanoel.vendedores.dto.RegiaoAtuacaoRequest;
import com.emanoel.vendedores.model.RegiaoAtuacao;
import com.emanoel.vendedores.repository.RegiaoAtuacaoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RegiaoAtuacaoServiceTest {
    @Autowired
    private RegiaoAtuacaoService atuacaoService;

    @Autowired
    private RegiaoAtuacaoRepository atuacaoRepository;

    @Test
    public void whenAddingRegion_shouldInsertRegionCorrectly() {

        String nomeRegiao = "sudeste";

        ArrayList<String> estados = new ArrayList<>();
            estados.add("ES");
            estados.add("MG");
            estados.add("RJ");
            estados.add("SP");

        RegiaoAtuacaoRequest request = RegiaoAtuacaoRequest.builder()
            .regiao(nomeRegiao)
            .estados(estados)
            .build();

        RegiaoAtuacao regiaoInserida = atuacaoService.addRegiao(request);

        assertNotNull(regiaoInserida.getId());
        assertEquals(nomeRegiao, regiaoInserida.getRegiao());
        assertIterableEquals(estados, Arrays.asList(regiaoInserida.getEstados()));
    }

    @Test
    public void whenSearchingForRegion_shouldReturnRegionCorrectly() {

        String nomeRegiao = "sul";
        ArrayList<String> estados = new ArrayList<>();
        estados.add("PR");
        estados.add("RS");
        estados.add("SC");

        RegiaoAtuacao atuacao = RegiaoAtuacao.builder()
            .regiao(nomeRegiao)
            .estados(estados.toArray(new String[0]))
            .build();

        RegiaoAtuacao regiaoInserida = atuacaoRepository.save(atuacao);

        assertNotNull(regiaoInserida.getId());
        assertNotNull(regiaoInserida.getRegiao());
        assertNotNull(regiaoInserida.getEstados());

        //---------------------------------------------------------------------------------------

        RegiaoAtuacao regiaoBuscada = atuacaoService.getRegiao(nomeRegiao);

        assertEquals(regiaoInserida.getId(), regiaoBuscada.getId());
        assertEquals(regiaoInserida.getRegiao(), regiaoBuscada.getRegiao());
        assertArrayEquals(regiaoInserida.getEstados(), regiaoBuscada.getEstados());
    }
}
