package com.emanoel.vendedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanoel.vendedores.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
