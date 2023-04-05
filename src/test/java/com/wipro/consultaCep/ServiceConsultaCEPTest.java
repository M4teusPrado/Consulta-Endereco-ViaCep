package com.wipro.consultaCep;

import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.service.ServiceConsultaCEP;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertThrows;

public class ServiceConsultaCEPTest {

    private ServiceConsultaCEP serviceConsultaCEP;

    @Before
    public void setUp() {
        this.serviceConsultaCEP = new ServiceConsultaCEP();
    }

    @Test
    public void testValidarCEPComCEPInvalido() {
        String cep = "1234";
        assertThrows(ResponseStatusException.class, () -> serviceConsultaCEP.validarCEP(cep));
    }

    @Test
    public void testValidarCEPComCEPVazio() {
        String cep = "";
        assertThrows(ResponseStatusException.class, () -> serviceConsultaCEP.validarCEP(cep));
    }

    @Test
    public void testValidarEnderecoEncontradoComEnderecoNulo() {
        Endereco endereco = new Endereco();
        assertThrows(ResponseStatusException.class, () -> serviceConsultaCEP.validarEnderecoEncontrado(endereco));
    }

    @Test
    public void testValidarEnderecoEncontradoComCampoDoEnderecoNulo() {
        Endereco endereco = new Endereco();
        endereco.setCep("01001000");
        endereco.setLogradouro(null);
        endereco.setBairro("Sé");
        endereco.setLocalidade("São Paulo");
        endereco.setUf("SP");
        assertThrows(ResponseStatusException.class, () -> serviceConsultaCEP.validarEnderecoEncontrado(endereco));
    }
}
