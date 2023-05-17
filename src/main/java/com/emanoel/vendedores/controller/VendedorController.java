package com.emanoel.vendedores.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emanoel.vendedores.dto.RegiaoAtuacaoRequest;
import com.emanoel.vendedores.dto.VendedorRequest;
import com.emanoel.vendedores.dto.VendedorResponse;
import com.emanoel.vendedores.dto.VendedorUnicoResponse;
import com.emanoel.vendedores.model.RegiaoAtuacao;
import com.emanoel.vendedores.model.Vendedor;
import com.emanoel.vendedores.service.RegiaoAtuacaoService;
import com.emanoel.vendedores.service.VendedorService;

@RestController
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private RegiaoAtuacaoService regiaoAtuacaoService;

    @PostMapping("/vendedor")
    public ResponseEntity<Vendedor> addVendedor(@RequestBody VendedorRequest request) {
        Vendedor vendedorInserido = vendedorService.addVendedor(request);

        return new ResponseEntity<Vendedor>(vendedorInserido, HttpStatus.CREATED);
    }

    @PostMapping("/atuacao")
    public ResponseEntity<RegiaoAtuacao> addRegiaoAtuacao(@RequestBody RegiaoAtuacaoRequest request) {
        RegiaoAtuacao regiaoInserida = regiaoAtuacaoService.addRegiao(request);

        return new ResponseEntity<RegiaoAtuacao>(regiaoInserida, HttpStatus.CREATED);
    }

    @GetMapping("vendedor/{id}")
    public ResponseEntity<VendedorUnicoResponse> getVendedor(@PathVariable Long id) {
        VendedorUnicoResponse vendedorEncontrado = vendedorService.getVendedor(id);

        if(Objects.isNull(vendedorEncontrado)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<VendedorUnicoResponse>(vendedorEncontrado, HttpStatus.OK);
    }

    @GetMapping("/vendedor")
    public ResponseEntity<List<VendedorResponse>> getAllVendedores() {
        ArrayList<VendedorResponse> vendedoresEncontrados = new ArrayList<>(vendedorService.getAllVendedores());

        if(vendedoresEncontrados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<VendedorResponse>>(vendedoresEncontrados, HttpStatus.OK);
    }

}
