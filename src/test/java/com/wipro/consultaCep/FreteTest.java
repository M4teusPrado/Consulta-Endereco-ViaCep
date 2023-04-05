package com.wipro.consultaCep;

import com.wipro.consultaCep.DTO.AddressResponse;
import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.model.Enums.FreteRegiao;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FreteTest {

    @Test
    public void testGerarFrete() {
        // Testando a geração de frete para cada região do Brasil
        Assertions.assertEquals(20.83, FreteRegiao.NORTE.getValorFrete());
        Assertions.assertEquals(15.98, FreteRegiao.NORDESTE.getValorFrete());
        Assertions.assertEquals(12.50, FreteRegiao.CENTRO_OESTE.getValorFrete());
        Assertions.assertEquals(7.85, FreteRegiao.SUDESTE.getValorFrete());
        Assertions.assertEquals(17.30, FreteRegiao.SUL.getValorFrete());
    }

    @Test
    public void testAddressResponse() {
        // Testando a criação do objeto AddressResponse a partir de um objeto Endereco
        Endereco endereco = new Endereco();
        endereco.setCep("12345-678");
        endereco.setLogradouro("Rua Teste");
        endereco.setComplemento("Apto 123");
        endereco.setBairro("Bairro Teste");
        endereco.setLocalidade("Cidade Teste");
        endereco.setUf("SP");

        AddressResponse addressResponse = new AddressResponse(endereco);

        Assertions.assertEquals("12345-678", addressResponse.getCep());
        Assertions.assertEquals("Rua Teste", addressResponse.getRua());
        Assertions.assertEquals("Apto 123", addressResponse.getComplemento());
        Assertions.assertEquals("Bairro Teste", addressResponse.getBairro());
        Assertions.assertEquals("Cidade Teste", addressResponse.getCidade());
        Assertions.assertEquals("SP", addressResponse.getEstado());
        Assertions.assertEquals(7.85, addressResponse.getFrete());
    }

}
