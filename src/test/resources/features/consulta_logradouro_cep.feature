Feature: Consulta de logradouro por CEP
  Como um usuário
  Eu quero consultar um endereço por CEP
  Para que eu possa obter informações sobre o logradouro

  Scenario: Consultar logradouro por CEP válido
    Given que informei o CEP "01001000"
    When eu realizo a consulta de endereço por CEP
    Then o resultado da consulta deve conter o endereço "Praça da Sé"

  Scenario: Consultar logradouro por CEP válido
    Given que informei o CEP "18117140"
    When eu realizo a consulta de endereço por CEP
    Then o resultado da consulta deve conter o endereço "Rua Ana Marina do Espírito Santo"
