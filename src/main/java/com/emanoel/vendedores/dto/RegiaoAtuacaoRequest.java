package com.emanoel.vendedores.dto;

import java.util.List;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class RegiaoAtuacaoRequest {
    private String regiao;
    private List<String> estados;
}
