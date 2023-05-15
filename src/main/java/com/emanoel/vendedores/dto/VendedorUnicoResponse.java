package com.emanoel.vendedores.dto;

import java.util.List;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendedorUnicoResponse {
    private String nome;
    private LocalDate dataInclusao;
    private List<String> estados;
}
