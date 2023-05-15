package com.emanoel.vendedores.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emanoel.vendedores.dto.VendedorRequest;
import com.emanoel.vendedores.dto.VendedorResponse;
import com.emanoel.vendedores.dto.VendedorUnicoResponse;
import com.emanoel.vendedores.model.RegiaoAtuacao;
import com.emanoel.vendedores.model.Vendedor;
import com.emanoel.vendedores.repository.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private RegiaoAtuacaoService regiaoAtuacaoService;


    public Vendedor addVendedor(VendedorRequest request) {
        Vendedor vendedor = Vendedor.builder()
            .dataInclusao(LocalDate.now())
            .nome(request.getNome())
            .telefone(request.getTelefone())
            .idade(request.getIdade())
            .cidade(request.getCidade())
            .estado(request.getEstado())
            .regiao(request.getRegiao())
            .build();

        return vendedorRepository.save(vendedor);
    }

    public VendedorUnicoResponse getVendedor(Long id) {
        Vendedor vendedor = vendedorRepository.findById(id).get();
        RegiaoAtuacao regiao = regiaoAtuacaoService.getRegiao(vendedor.getRegiao());

        return VendedorUnicoResponse.builder()
        .nome(vendedor.getNome())
        .dataInclusao(vendedor.getDataInclusao())
        .estados(Arrays.asList(regiao.getEstados()))
        .build();
    }

    private VendedorResponse convertFromVendedor(Vendedor vendedor) {
        RegiaoAtuacao regiao = regiaoAtuacaoService.getRegiao(vendedor.getRegiao());

        return VendedorResponse.builder()
            .nome(vendedor.getNome())
            .telefone(vendedor.getTelefone())
            .idade(vendedor.getIdade())
            .cidade(vendedor.getCidade())
            .estado(vendedor.getEstado())
            .estados(Arrays.asList(regiao.getEstados()))
            .build();
    }

    public List<VendedorResponse> getAllVendedores() {
        return vendedorRepository.findAll()
        .stream()
        .map(this::convertFromVendedor)
        .collect(Collectors.toList());
    }
}
