### Projeto Spring Boot gerado c/ os módulos:
- Spring Data JPA (persistência de dados)
- Spring Web (APIs REST)
- H2 Db (Banco de dados em memória)
- OpenFeign (Consumo de APIs)


1) Inclusão ``@EnableFeignClients`` na classe ``PadroesProjetoSpringApplication`` para habilitar o Feign no projeto;
2) Além das dependências incluídas no Initizi, incluída a do OpenAPI para documentar as APIs
   ````xml
    <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-ui</artifactId>
      <version>1.6.12</version>
    </dependency>
    ````
3) Foi usado o JSON [https://viacep.com.br](https://viacep.com.br) para gerar o código da classe Endereço no site [https://www.jsonschema2pojo.org/](https://www.jsonschema2pojo.org);
4) Criados os modelos de dados e seus repository (model);
5) Criamos a interface de serviço (service) para Cliente;
6) Implementamos a interface do Cliente;
7) Criamos a interface ViaCepService que tem a lógica para consumo da API de Cep;
8) Criamos a controller ClienteController