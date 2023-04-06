package com.wipro.consultaCep;

import static org.mockito.Mockito.when;

import java.io.IOException;

import com.wipro.consultaCep.DTO.AddressRequest;
import com.wipro.consultaCep.DTO.AddressResponse;
import com.wipro.consultaCep.controller.ControllerConsultaCEP;
import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.service.ServiceConsultaCEP;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@RunWith(MockitoJUnitRunner.class)
public class ControllerConsultaCEPTest {

    @Mock
    private ServiceConsultaCEP serviceConsultaCEP;

    private ControllerConsultaCEP controllerConsultaCEP;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controllerConsultaCEP = new ControllerConsultaCEP(serviceConsultaCEP);
    }

    @Test
    public void testConsultarEnderecoComSucesso() throws IOException {


        AddressRequest endereco = new AddressRequest();
        endereco.setCep("01001000");

        AddressResponse enderecoEsperado = new AddressResponse();
        enderecoEsperado.setCep("01001000");
        enderecoEsperado.setRua("Praça da Sé");
        enderecoEsperado.setBairro("Sé");
        enderecoEsperado.setCidade("São Paulo");
        enderecoEsperado.setEstado("SP");
        enderecoEsperado.setEstado("SP");
        when(serviceConsultaCEP.consultarEnderecoPorCep(endereco)).thenReturn(enderecoEsperado);

        AddressResponse addressResponse = controllerConsultaCEP.consultarEndereco(endereco);
        Assert.assertEquals(enderecoEsperado, addressResponse);
    }

    @Test(expected = ResponseStatusException.class)
    public void testConsultarEnderecoComErro() throws IOException {
        AddressRequest endereco = new AddressRequest();
        endereco.setCep("12345678");
        when(serviceConsultaCEP.consultarEnderecoPorCep(endereco)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
        controllerConsultaCEP.consultarEndereco(endereco);
    }
}