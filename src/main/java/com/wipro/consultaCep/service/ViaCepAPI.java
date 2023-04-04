package com.wipro.consultaCep.service;

import java.io.IOException;

public interface ViaCepAPI {
    String consultarEnderecoPorCep(String cep) throws IOException;
}
