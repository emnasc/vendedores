package com.emanoel.vendedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanoel.vendedores.model.RegiaoAtuacao;

public interface RegiaoAtuacaoRepository extends JpaRepository<RegiaoAtuacao, Long> {

    RegiaoAtuacao findByRegiao(String regiao);
}
