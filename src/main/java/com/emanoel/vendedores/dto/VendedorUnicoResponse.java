package com.emanoel.vendedores.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendedorUnicoResponse {
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dataInclusao;
    private List<String> estados;
}
