package com.wipro.consultaCep;

import com.wipro.consultaCep.model.RegioesDoBrasil;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.assertEquals;

public class ConsultaFretePorRegiaoSteps {

    private String uf;
    private double valorFreteCalculado;

    @Dado("que informei o CEP, e sua localização seja em {string}")
    public void informacaoUF(String uf) {
        this.uf = uf;
    }

    @Quando("eu realizo a consulta de frete por regiao")
    public void realizarBusca() {
        this.valorFreteCalculado = RegioesDoBrasil.obterRegiaoPorEstado(uf).getValorFrete();
    }

    @Então("o frete para essa região deve ser igual a {double}")
    public void verificaValorFrete(double frete) {
        assertEquals(valorFreteCalculado, frete, 0.00000f);
    }
}