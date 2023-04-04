package com.wipro.consultaCep.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class ViaCepAPIImpl implements ViaCepAPI {

    private static final String URL_VIACEP = "https://viacep.com.br/ws/";

    @Override
    public String consultarEnderecoPorCep(String cep) throws IOException {
        URL url = construirUrl(cep);
        InputStream is = conectarComApi(url);
        return extrairEnderecoDoJson(is);
    }

    private URL construirUrl(String cep) throws MalformedURLException {
        return new URL(URL_VIACEP + cep + "/json/");
    }

    private InputStream conectarComApi(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        return connection.getInputStream();
    }

    private String extrairEnderecoDoJson(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String buffer;
        while ((buffer = br.readLine()) != null)
            response.append(buffer);
        br.close();
        return response.toString();
    }
}
