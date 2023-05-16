package com.emanoel.vendedores.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegiaoAtuacao {
    @Id
    @GeneratedValue
    private Long id;

    private String regiao;
    private String[] estados;
}
