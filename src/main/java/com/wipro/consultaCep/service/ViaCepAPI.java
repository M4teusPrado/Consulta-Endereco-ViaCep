package com.wipro.consultaCep.service;

import com.wipro.consultaCep.model.Endereco;

import java.io.IOException;

public interface ViaCepAPI {
    Endereco consultarEnderecoPorCep(String cep) throws IOException;
}
