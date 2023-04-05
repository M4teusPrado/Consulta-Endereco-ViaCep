package com.wipro.consultaCep.model.Enums;

public enum FreteRegiao {

    NORTE(20.83),
    NORDESTE(15.98),
    CENTRO_OESTE(12.50),
    SUDESTE(7.85),
    SUL(17.30);

    private double valorFrete;

    FreteRegiao(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorFrete() {
        return valorFrete;
    }
}