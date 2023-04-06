Feature: Consulta do frete por regiao
  Como um usuário
  Eu quero consultar o valor do frete
  Para saber se continuo com a compra ou não

  Scenario: Consultar frete por CEP Regiao
    Given que informei o CEP, e sua localização seja em "AM"
    When eu realizo a consulta de frete por regiao
    Then o frete para essa região deve ser igual a 20.83

  Scenario: Consultar frete por CEP Regiao
    Given que informei o CEP, e sua localização seja em "SE"
    When eu realizo a consulta de frete por regiao
    Then o frete para essa região deve ser igual a 15.98

  Scenario: Consultar frete por CEP Regiao
    Given que informei o CEP, e sua localização seja em "DF"
    When eu realizo a consulta de frete por regiao
    Then o frete para essa região deve ser igual a 12.50

  Scenario: Consultar frete por CEP Regiao
    Given que informei o CEP, e sua localização seja em "SP"
    When eu realizo a consulta de frete por regiao
    Then o frete para essa região deve ser igual a 7.85

  Scenario: Consultar frete por CEP Regiao
    Given que informei o CEP, e sua localização seja em "SC"
    When eu realizo a consulta de frete por regiao
    Then o frete para essa região deve ser igual a 17.30

