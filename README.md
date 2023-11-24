# Global Solution
Repositório com código JAVA - Global Solution

Este é um projeto Java WEB com Maven.  

O Projeto conta com uso de classes BO, DAO e Resource, Metodos de Modelo de Negócio, conexão e interação com Banco de Dados SQL Oracle;

Falando em ESTRUTURA e FUNCIONAMENTO do projeto, nosso código está dividido em 6 packages:

1 - BEANS → Nesse pacote instanciamos as 6 classes que compõem os objetos do sistema. As classes são: Login, DadosUsuario, Predicao.

2 - MAIN → Nesse pacote, temos 5 classes. TesteConexao e InsertPredicao, InsertDadosUsuario, SelectDadosUsuario e InsertLogin. As cinco classes são referentes a conexão e cadastro de registros no Banco de Dados.

3 - DAO → Nesse package temos a preparação dos métodos que irão interagir (Criar, Ler, Atualizar e Deletar) com nosso banco de dados.

4 - CONECTIONS → Este pacote é responsavel pela introdução de credenciais e conexão com nosso Banco de Dados Oracle, atraves da Classe ConexaoFactory.

5 - BO → Esse pacote serve para chamar os métodos da classe DAO, sendo um intermediario entre o Package Resource e o DAO. Nele podemos incluir regras de negócio, coordenar operações, encapsular dados entre outras operações. 

6 - RESOURCE → Se tratando de um projeto Java Web com API REST, neste pacote criamos o Endpoint e o método que esse endpoint irá executar. No caso, Um método GET(READ) para ler os dados do usuario já existente da tabela T_SI_DADOS_USUARIO de nosso banco, através do id_usuario.

OBS: Para utilizar nosso código, se atente as credenciais do Banco de Dados, na Classe ConexaoFactory, do Package conexoes.
