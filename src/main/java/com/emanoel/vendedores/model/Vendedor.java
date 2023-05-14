package com.emanoel.vendedores.model;

import java.util.Date;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@Entity(name="vendedor")
public class Vendedor {
    @Id
    @GeneratedValue
    private Integer id;
    private Date dataInclusao;

    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado; //TODO: alterar para Enum?
    private Atuacao regiao; //TODO: alterar para Enum?


}
