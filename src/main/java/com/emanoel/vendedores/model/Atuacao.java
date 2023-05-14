package com.emanoel.vendedores.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name="atuacao")
public class Atuacao {
    private String regiao;
    private List<String> estados;
}
