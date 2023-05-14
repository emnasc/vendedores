package com.emanoel.vendedores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Atuacao {
    @Id
    @GeneratedValue
    private Long id;

    private String regiao;
    private List<String> estados;
}
