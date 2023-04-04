package com.wipro.consultaCep.controller;

import com.wipro.consultaCep.model.Address;
import com.wipro.consultaCep.service.ViaCepAPIImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class consultaCEPController {

    @PostMapping
    public ResponseEntity<String> cadastrar(@Valid @RequestBody Address endereco) throws IOException {
        String st= consultarEnderecoPorCep(endereco.getCep());
        return ResponseEntity.ok().body(st);
    }

    public String consultarEnderecoPorCep(String cep) throws IOException {
        return new ViaCepAPIImpl().consultarEnderecoPorCep(cep);
    }
}
