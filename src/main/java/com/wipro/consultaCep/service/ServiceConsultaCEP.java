package com.wipro.consultaCep.service;

import com.wipro.consultaCep.DTO.AddressResponse;
import com.wipro.consultaCep.model.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class ServiceConsultaCEP {

    private static final Long QNTD_CARACTERES_CEP = 8L;

    public AddressResponse consultarEnderecoPorCep(Endereco endereco) throws IOException {
        String cep = validarCEP(endereco.getCep());
        Endereco enderecoEncontrado = buscarEndereco(cep);
        validarEnderecoEncontrado(enderecoEncontrado);
        return new AddressResponse(enderecoEncontrado);
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
        if (cep == null || cep.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP obrigatório.");
        }

        if (cep.length() != QNTD_CARACTERES_CEP)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP é invalido");
    }

    private Endereco buscarEndereco(String cep) throws IOException {
        return new ViaCepAPIImpl().consultarEnderecoPorCep(cep);
    }

    private void validarEnderecoEncontrado(Endereco enderecoEncontrado) {
        if (enderecoEncontrado.getCep() == null || enderecoEncontrado.getLogradouro() == null
                || enderecoEncontrado.getBairro() == null || enderecoEncontrado.getLocalidade() == null || enderecoEncontrado.getUf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereço não encontrado para o CEP informado.");
        }
    }
}
