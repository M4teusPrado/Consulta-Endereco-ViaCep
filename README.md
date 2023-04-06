## Consulta Endereço via CEP

<p> API REST de consulta de endereço e cálculo de frete para
um determinado CEP. O contrato da API deve ser conforme especificado abaixo:

POST v1/consulta-endereco </p>

#### REQUEST

```json
{
  "cep": "01001000"
}
```

##### RESPONSE 200

```json
{
  "cep": "01001-000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "cidade": "São Paulo",
  "estado": "SP",
  "frete": 7.85
}
```

Para a busca do endereço do CEP, você deve consultar a API VIA CEP, conforme a
documentação https://viacep.com.br/. 
O valor do frete é fixo de acordo com as regiões
do Brasil: 
- Sudeste (R$ 7,85)
- Centro-Oeste (R$ 12,50)
- Nordeste (R$ 15,98)
- Sul (R$ 17,30)
- Norte (R$ 20,83). 
  
O CEP é obrigatório e pode ser passado com ou sem máscara na entrada e se o CEP não for encontrado uma mensagem informativa deve ser retornada
para o cliente.

### Requisitos para o desenvolvimento:
 - Java 11
 - Spring boot
 - API REST Template
 - Documentação Swagger
 - Testes unitários JUnit5
 - Testes automatizados utilizando cucumber
