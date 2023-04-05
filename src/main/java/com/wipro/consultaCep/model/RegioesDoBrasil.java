package com.wipro.consultaCep.model;

import com.wipro.consultaCep.model.Enums.FreteRegiao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RegioesDoBrasil {

    private static final Map<String, FreteRegiao> ESTADOS_POR_REGIAO;

    static {
        Map<String, FreteRegiao> estadosPorRegiao = new HashMap<>();
        estadosPorRegiao.put("AC", FreteRegiao.NORTE);
        estadosPorRegiao.put("AL", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("AP", FreteRegiao.NORTE);
        estadosPorRegiao.put("AM", FreteRegiao.NORTE);
        estadosPorRegiao.put("BA", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("CE", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("DF", FreteRegiao.CENTRO_OESTE);
        estadosPorRegiao.put("ES", FreteRegiao.SUDESTE);
        estadosPorRegiao.put("GO", FreteRegiao.CENTRO_OESTE);
        estadosPorRegiao.put("MA", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("MT", FreteRegiao.CENTRO_OESTE);
        estadosPorRegiao.put("MS", FreteRegiao.CENTRO_OESTE);
        estadosPorRegiao.put("MG", FreteRegiao.SUDESTE);
        estadosPorRegiao.put("PA", FreteRegiao.NORTE);
        estadosPorRegiao.put("PB", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("PR", FreteRegiao.SUL);
        estadosPorRegiao.put("PE", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("PI", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("RJ", FreteRegiao.SUDESTE);
        estadosPorRegiao.put("RN", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("RS", FreteRegiao.SUL);
        estadosPorRegiao.put("RO", FreteRegiao.NORTE);
        estadosPorRegiao.put("RR", FreteRegiao.NORTE);
        estadosPorRegiao.put("SC", FreteRegiao.SUL);
        estadosPorRegiao.put("SP", FreteRegiao.SUDESTE);
        estadosPorRegiao.put("SE", FreteRegiao.NORDESTE);
        estadosPorRegiao.put("TO", FreteRegiao.NORTE);

        ESTADOS_POR_REGIAO = Collections.unmodifiableMap(estadosPorRegiao);
    }

    public static FreteRegiao obterRegiaoPorEstado(String siglaEstado) {
        return ESTADOS_POR_REGIAO.get(siglaEstado.toUpperCase());
    }

}
