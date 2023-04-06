package com.wipro.consultaCep.DTO;

import com.wipro.consultaCep.model.Endereco;
import com.wipro.consultaCep.model.RegioesDoBrasil;
import lombok.Data;

@Data
public class AddressResponse {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Double frete;

    public AddressResponse(Endereco endereco){
        this.cep = endereco.getCep();
        this.rua = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getLocalidade();
        this.estado = endereco.getUf();
        this.frete = gerarFrete(endereco.getUf());
    }

    public AddressResponse() {

    }

    private Double gerarFrete(String uf) {
        return RegioesDoBrasil.obterRegiaoPorEstado(uf).getValorFrete();
    }
}
