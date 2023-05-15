package com.emanoel.vendedores.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emanoel.vendedores.dto.VendedorRequest;
import com.emanoel.vendedores.dto.VendedorResponse;
import com.emanoel.vendedores.dto.VendedorUnicoResponse;
import com.emanoel.vendedores.model.RegiaoAtuacao;
import com.emanoel.vendedores.model.Vendedor;
import com.emanoel.vendedores.repository.RegiaoAtuacaoRepository;
import com.emanoel.vendedores.repository.VendedorRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class VendedorServiceTest {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private RegiaoAtuacaoRepository regiaoAtuacaoRepository;

    @Test
    public void whenAddingVendedor_shouldInsertCorrectly() {

        String nome = "Fulano de tal";
        String telefone = "(11)95555-4444";
        Integer idade = 24;
        String cidade = "Campinas";
        String estado = "SP";
        String regiao = "sudeste";

        VendedorRequest request = VendedorRequest.builder()
            .nome(nome)
            .telefone(telefone)
            .idade(idade)
            .cidade(cidade)
            .estado(estado)
            .regiao(regiao)
            .build();

        Vendedor vendedorInserido = vendedorService.addVendedor(request);

        assertNotNull(vendedorInserido.getId());
        assertEquals(nome, vendedorInserido.getNome());
        assertEquals(telefone, vendedorInserido.getTelefone());
        assertEquals(idade, vendedorInserido.getIdade());
        assertEquals(cidade, vendedorInserido.getCidade());
        assertEquals(estado, vendedorInserido.getEstado());
        assertEquals(regiao, vendedorInserido.getRegiao());
    }

    @Test
    public void whenFetchingVendedorById_shouldReturnVendedorCorrectly() {

        LocalDate fixedDate = LocalDate.now();
        //when(LocalDate.now()).thenReturn(fixedDate);

        //---------------------------------------------------------------------------------------

        String nomeRegiao = "sudeste";

        ArrayList<String> estados = new ArrayList<>();
            estados.add("ES");
            estados.add("MG");
            estados.add("RJ");
            estados.add("SP");

        RegiaoAtuacao regiao = RegiaoAtuacao.builder()
            .regiao(nomeRegiao)
            .estados(estados.toArray(new String[0]))
            .build();

        RegiaoAtuacao regiaoAtuacao = regiaoAtuacaoRepository.save(regiao);

        assertNotNull(regiaoAtuacao.getId());

        //---------------------------------------------------------------------------------------

        String nome = "Fulano de tal";
        String telefone = "(11)95555-4444";
        Integer idade = 24;
        String cidade = "Campinas";
        String estado = "SP";

        Vendedor vendedor = Vendedor.builder()
            .nome(nome)
            .telefone(telefone)
            .idade(idade)
            .cidade(cidade)
            .estado(estado)
            .regiao(nomeRegiao)
            .build();

        Vendedor vendedorInserido = vendedorRepository.save(vendedor);

        assertNotNull(vendedorInserido.getId());

        //---------------------------------------------------------------------------------------

        VendedorUnicoResponse vendedorBuscado = vendedorService.getVendedor(vendedorInserido.getId());

        assertEquals(vendedorInserido.getNome(), vendedorBuscado.getNome());
        assertEquals(vendedorInserido.getDataInclusao(), vendedorBuscado.getDataInclusao());
        assertIterableEquals(estados, vendedorBuscado.getEstados());
    }

    @Test
    public void whenFetchingAllVendedores_shouldReturnAllVendedoresCorrectly() {

        String nomeRegiao1 = "sudeste";

        ArrayList<String> estados1 = new ArrayList<>();
            estados1.add("ES");
            estados1.add("MG");
            estados1.add("RJ");
            estados1.add("SP");

        RegiaoAtuacao regiao1 = RegiaoAtuacao.builder()
            .regiao(nomeRegiao1)
            .estados(estados1.toArray(new String[0]))
            .build();

        RegiaoAtuacao regiaoAtuacao1 = regiaoAtuacaoRepository.save(regiao1);

        assertNotNull(regiaoAtuacao1.getId());

        String nomeRegiao2 = "sul";
        ArrayList<String> estados2 = new ArrayList<>();
        estados2.add("PR");
        estados2.add("RS");
        estados2.add("SC");

        RegiaoAtuacao regiao2 = RegiaoAtuacao.builder()
            .regiao(nomeRegiao2)
            .estados(estados2.toArray(new String[0]))
            .build();

        RegiaoAtuacao regiaoAtuacao2 = regiaoAtuacaoRepository.save(regiao2);

        assertNotNull(regiaoAtuacao2.getId());

        //---------------------------------------------------------------------------------------



            String nome1 = "Fulano de tal";
            String telefone1 = "(11)95555-4444";
            Integer idade1 = 24;
            String cidade1 = "Belo Horizonte";
            String estado1 = "MG";

            Vendedor vendedor1 = Vendedor.builder()
                .nome(nome1)
                .telefone(telefone1)
                .idade(idade1)
                .cidade(cidade1)
                .estado(estado1)
                .regiao(nomeRegiao1)
                .build();

            Vendedor vendedorInserido1 = vendedorRepository.save(vendedor1);
            assertNotNull(vendedorInserido1.getId());

            String nome2 = "Sicrano de tal";
            String telefone2 = "(11)93333-2222";
            Integer idade2 = 27;
            String cidade2 = "Osasco";
            String estado2 = "SP";

            Vendedor vendedor2 = Vendedor.builder()
                .nome(nome2)
                .telefone(telefone2)
                .idade(idade2)
                .cidade(cidade2)
                .estado(estado2)
                .regiao(nomeRegiao2)
                .build();

            Vendedor vendedorInserido2 = vendedorRepository.save(vendedor2);
            assertNotNull(vendedorInserido2.getId());

        //---------------------------------------------------------------------------------------

        VendedorResponse response1 = VendedorResponse.builder()
            .nome(nome1)
            .telefone(telefone1)
            .idade(idade1)
            .cidade(cidade1)
            .estado(estado1)
            .estados(estados1)
            .estados(estados1)
            .build();

        VendedorResponse response2 = VendedorResponse.builder()
            .nome(nome2)
            .telefone(telefone2)
            .idade(idade2)
            .cidade(cidade2)
            .estado(estado2)
            .estados(estados2)
            .estados(estados2)
            .build();

        ArrayList<VendedorResponse> expected = new ArrayList<>();
        expected.add(response1);
        expected.add(response2);

        //---------------------------------------------------------------------------------------

        ArrayList<VendedorResponse> vendedoresBuscados = new ArrayList<>(vendedorService.getAllVendedores());
        assertIterableEquals(expected, vendedoresBuscados);
    }
}
