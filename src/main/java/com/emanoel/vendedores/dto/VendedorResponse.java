package com.emanoel.vendedores.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class VendedorResponse {
    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private List<String> estados;
}
