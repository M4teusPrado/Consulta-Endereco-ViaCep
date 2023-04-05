package com.wipro.consultaCep.controller;

import com.wipro.consultaCep.DTO.AddressResponse;
import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.service.ServiceConsultaCEP;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class ControllerConsultaCEP {

    @Autowired
    ServiceConsultaCEP serviceConsultaCEP;

    @PostMapping
    public AddressResponse consultarEndereco(@Valid @RequestBody Endereco endereco)  {
        try {
            return serviceConsultaCEP.consultarEnderecoPorCep(endereco);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao consultar API ViaCep", e);
        }
    }
}
