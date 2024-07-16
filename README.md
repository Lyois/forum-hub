![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)&nbsp;
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)&nbsp;
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)


# Challenge Hub Forum 2024

## Apresentação

Este é um projeto realizado durante o curso de Java oferecido pela Alura para as turmas do Oracle ONE. Conhecido como Fórum HUB, este  
projeto consiste em uma API REST desenvolvida em Java utilizando o Spring Boot. Ele simula um fórum de discussão onde os usuários podem  
criar, visualizar, atualizar e deletar tópicos de discussão, perfis, respostas, cursos e usuários. A partir de agora, apenas usuários autenticados  
podem interagir com a API. 

## O Hub Forum permite:

* Cadastramento de autor
* Cadastro de tópicos.
* Listagem de tópicos salvos.
* Detalhes de tópicos salvos.
* Edição no registro de tópicos.
* Exclusão lógica do registro de tópicos.

## Configuração MYSQL

Defina as seguintes variáveis de ambiente:

* `DB_HOST`: Host do MYSQL (se estiver rodando localmente, será localhost)
* `DB_NAME`: Nome do banco de dados criado
* `DB_USER`: Seu usuário do MYSQL
* `DB_PASSWORD`: Sua senha do MYSQL

No arquivo de configuração, utilize as variáveis da seguinte maneira:

```
spring.datasource.url=jdbc:mysql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

## Acesso a API

Para acessar a API, após configurar o Banco de Dados MySQL e rodar a API, basta acessar o endereço  
```(http://"server:port/context-path"/swagger-ui.html)``` pelo navegador.
