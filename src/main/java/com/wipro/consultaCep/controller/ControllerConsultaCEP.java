package com.wipro.consultaCep.controller;

import com.wipro.consultaCep.DTO.AddressRequest;
import com.wipro.consultaCep.DTO.AddressResponse;
import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.service.ServiceConsultaCEP;
import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ControllerConsultaCEP(ServiceConsultaCEP serviceConsultaCEP) {
        this.serviceConsultaCEP = serviceConsultaCEP;
    }

    @ApiOperation(value = "Buscar endereço e calcular frete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um endereço com o frete calculado"),
            @ApiResponse(code = 400, message = "Erro de validação"),
            @ApiResponse(code = 500, message = "Erro do servidor"),
    })
    @PostMapping
    public AddressResponse consultarEndereco(@Valid @RequestBody AddressRequest enderecoDTO)  {
        try {
            return serviceConsultaCEP.consultarEnderecoPorCep(enderecoDTO);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao consultar API ViaCep", e);
        }
    }
}
