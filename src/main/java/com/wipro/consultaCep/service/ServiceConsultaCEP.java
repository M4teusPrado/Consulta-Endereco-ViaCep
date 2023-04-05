package com.wipro.consultaCep.service;

import com.wipro.consultaCep.DTO.AddressResponse;
import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.model.Enums.FreteRegiao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class ServiceConsultaCEP {

    private static final Long QNTD_CARACTERES_CEP = 8L;

    public AddressResponse consultarEnderecoPorCep(Endereco endereco) throws IOException {
        String cep = validarCEP(endereco.getCep());
        endereco = new ViaCepAPIImpl().consultarEnderecoPorCep(cep);
        return new AddressResponse(endereco);
    }

    private String validarCEP(String cep) {
        cep = removeCaracteresEspeciais(cep);
        verficaQuantidadeCaracteresCEP(cep);
        return cep;
    }

    private String removeCaracteresEspeciais(String cep) {
        return cep.replaceAll("[^\\d]", "");
    }

    private void verficaQuantidadeCaracteresCEP(String cep) {
        if (cep.length() != QNTD_CARACTERES_CEP)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP é invalido");
    }
}
