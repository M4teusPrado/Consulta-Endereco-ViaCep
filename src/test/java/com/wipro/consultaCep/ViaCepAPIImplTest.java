package com.wipro.consultaCep;

import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.service.ViaCepAPIImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ViaCepAPIImplTest {


    @Test
    public void testConstruirUrl() throws MalformedURLException {
        String cep = "01001000";
        URL expected = new URL("https://viacep.com.br/ws/01001000/json/");
        URL actual = ViaCepAPIImpl.construirUrl(cep);
        assertEquals(expected, actual);
    }

    @Test
    public void testConectarComApi() throws IOException {
        URL url = new URL("https://viacep.com.br/ws/01001000/json/");
        assertNotNull(ViaCepAPIImpl.conectarComApi(url));
    }

    @Test
    public void testConsultarEnderecoPorCep() throws IOException {
        ViaCepAPIImpl viaCepAPI = new ViaCepAPIImpl();
        String cep = "01001000";
        Endereco endereco = viaCepAPI.consultarEnderecoPorCep(cep);
        assertEquals("São Paulo", endereco.getLocalidade());
        assertEquals("SP", endereco.getUf());
        assertEquals("Praça da Sé", endereco.getLogradouro());
        assertEquals("Sé", endereco.getBairro());
    }
}
