package com.emanoel.vendedores.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendedorRequest {
    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private String regiao;
}
