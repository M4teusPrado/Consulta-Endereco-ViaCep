package com.wipro.consultaCep;

import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.service.ServiceConsultaCEP;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ConsultaEnderecoPorCEPSteps {

    private String cep;
    private Endereco endereco;

    @Dado("que informei o CEP {string}")
    public void informacaoCEP(String cep) {
        this.cep = cep;
    }

    @Quando("eu realizo a consulta de endereço por CEP")
    public void realizarBusca() throws IOException {
        ServiceConsultaCEP serviceConsultaCEP = new ServiceConsultaCEP();
        this.endereco = serviceConsultaCEP.buscarEndereco(cep);
    }

    @Então("o resultado da consulta deve conter o endereço {string}")
    public void conterLogradouro(String endereco) {
        assertEquals(true, this.endereco.getLogradouro().contains(endereco));
    }
}