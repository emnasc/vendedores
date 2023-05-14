package com.emanoel.vendedores.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@Entity
public class Vendedor {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dataInclusao;

    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private String regiao;
}
