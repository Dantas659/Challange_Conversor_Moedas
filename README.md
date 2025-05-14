# Conversor de Moedas em Java

## Descrição

Este projeto é uma aplicação didática desenvolvida para praticar e aplicar conceitos fundamentais da linguagem Java, especialmente os pilares da Orientação a Objetos (OO). Além disso, o projeto incorpora o consumo de APIs RESTful e a manipulação de dados JSON, proporcionando uma experiência prática com tecnologias modernas frequentemente usadas no desenvolvimento Java.

## Objetivos do Projeto

* Reforçar os conceitos de **encapsulamento**, **herança** e **polimorfismo** em Java.
* Aprender a consumir dados de uma API externa usando a biblioteca `HttpClient` do Java.
* Manipular dados JSON utilizando a biblioteca **Gson** do Google.
* Construir uma aplicação interativa que realiza conversão de moedas com base em taxas reais obtidas via API.

## Funcionalidades

* O usuário escolhe duas moedas a partir de uma lista (como Real Brasileiro, Dólar Americano, Peso Argentino etc.).
* Informa o valor a ser convertido.
* A aplicação consulta uma API de taxas de câmbio para obter a taxa de conversão atual.
* Exibe o valor convertido com base na taxa atual.
* Permite repetir o processo até o usuário escolher sair.

## Tecnologias Utilizadas

* **Java 11+** (uso do `HttpClient` nativo)
* **Gson** para deserialização de JSON
* API externa para taxas de câmbio (exchangerate-api.com)

## Estrutura do Projeto

* `Conversor`: classe principal que contém a lógica para interação com o usuário, consumo da API e cálculo.
* `ConversorMoedas`: classe que executa o loop principal da aplicação.
* Utilização de métodos para modularização e clareza no código.
* Uso do `Scanner` para entrada de dados do usuário.

## Como executar

1. Certifique-se de ter o JDK 11 ou superior instalado.

2. Faça o download do arquivo `gson-2.13.1.jar` e coloque-o na pasta `lib` do projeto.

3. Compile as classes com:

   ```bash
   javac -cp "lib/gson-2.13.1.jar" src/*.java
   ```

4. Execute o programa com:

   ```bash
   java -cp "lib/gson-2.13.1.jar;src" ConversorMoedas
   ```

5. Siga as instruções no terminal para realizar as conversões.

## Considerações Finais

Este projeto é um excelente exercício para consolidar os conhecimentos de Java, integração com serviços externos e manipulação de formatos de dados amplamente utilizados. Pode ser expandido para incluir mais moedas, tratar erros de forma mais robusta, e melhorar a interface com o usuário.

