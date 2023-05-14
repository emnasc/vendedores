package com.emanoel.vendedores.dto;

import java.util.List;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendedorUnicoResponse {
    private String nome;
    private Date dataInclusao;
    private List<String> estados;
}
