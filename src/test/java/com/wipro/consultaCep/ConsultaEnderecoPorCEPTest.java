package com.wipro.consultaCep;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/consulta_logradouro_cep.feature")
public class ConsultaEnderecoPorCEPTest {

}