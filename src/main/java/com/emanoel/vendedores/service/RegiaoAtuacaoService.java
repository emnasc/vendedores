package com.emanoel.vendedores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanoel.vendedores.dto.RegiaoAtuacaoRequest;
import com.emanoel.vendedores.model.RegiaoAtuacao;
import com.emanoel.vendedores.repository.RegiaoAtuacaoRepository;

@Service
public class RegiaoAtuacaoService {

    @Autowired
    private RegiaoAtuacaoRepository atuacaoRepository;

    public RegiaoAtuacao addRegiao(RegiaoAtuacaoRequest request) {
        RegiaoAtuacao atuacao = RegiaoAtuacao.builder()
            .regiao(request.getRegiao())
            .estados(request.getEstados().toArray(new String[0]))
            .build();

        return atuacaoRepository.save(atuacao);
    }

    public RegiaoAtuacao getRegiao(String regiao) {
        return atuacaoRepository.findByRegiao(regiao);
    }
}
