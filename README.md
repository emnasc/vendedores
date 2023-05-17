# Vendedores

Aplicação RESTful para cadastro de vendedores e suas regiões de atuação.

## Sobre o projeto
Esta é um aplicação RESTful simples para o cadastro de busca de vendedores e suas áreas de atuação.

----

## Dependências
Esta é uma aplicação baseada na versão 11 da linguagem Java, e faz uso do Maven como ferramenta de build. Ambas são necessárias para a instalação de dependências e execução da aplciação.

A aplicaçao foi contruída utilizando a versão 2.7.11 do framework Spring Boot, utilizando as seguintes bibliotecas:
- Spring Boot Data JPA
- Spring Web
- Lombok
- H2 Database
- Spring Test (JUnit 4 + Mockito)

----

## Executando a aplicação
Esta aplicação pode ser executada por meio da linha de comando por meio da Maven, da seguinte forma:

`mvn springboot:run`

A aplicação também pode ser compilada da seguinte forma:

`mvn compile`

----

## Endpoints e estrutura de requisições

### `/vendedor` (POST)
O vendedor enviado no corpo da requisição será cadastrado na base de dados. Os dados do vendedor devem ser enviados da seguinte forma:

```
{
	“nome”: “Fulano de Tal”,
	“telefone”: “99 99999-9999”,
	“idade”: 24,
	“cidade”: “Cidade de Fulano”,
	“estado”: “MG”,
	“regiao”: “sudeste”
}
```

Ao cadastrar o vendedor com sucesso, a aplicação responderá com status `201 (created)` e a estrutura de dados do vendedor cadastrado.


### `/vendedor/ID` (GET)
Caso o vendedor com o *ID* específicado esteja cadastrado na base de dados, suas informações serão retornadas com a seguinte estrutura de dados:

```
{
	“nome”: “Fulano de Tal”,
	“dataInclusao”: “DD/MM/AAAA”,
	“estados”: [
		“SP”,
		“RJ”,
		“MG”,
		“ES”
	]
}
```

Caso um vendedor com o *ID* específicado não esteja presente na base de dados, uma resposta vazia com status `204 (no content)` será retornada.


### `/vendedor` (GET)
A aplicação responderá com uma lista de todos os vendedores cadastrados na base de dados da aplicação, com a seguinte estrutura de dados:

```
[
	{
		“nome”: “Fulano de Tal”,
		“telefone”: “99 99999-9999”,
		“idade”: 99,
		“cidade”: “Cidade de Fulano”,
		“estado”: “MG”,
        “estados”: [
            “SP”,
            “RJ”,
            “MG”,
            “ES”
        ]
	},
	{
		“nome”: “Sicrano de Tal”,
		“telefone”: “99 99999-9999”,
		“idade”: 99,
		“cidade”: “Cidade de Sicrano”,
		“estado”: “SC”,
        “estados”: [
            “RS”,
            “PR”,
            “SC”
        ]
	},
    ...
]
```

Caso nenhum vendedor seja encontrado na base de dados, uma resposta vazia com status `204 (no content)` será retornada.


### `/atuacao` (POST)

A região de atuação enviada no corpo da requisição será cadastrada. A região de atuação deve ser enviada com a seguinte estrutura:

```
{
	“regiao”: “sudeste”,
	“estados”: [
		“SP”,
		“RJ”,
		“MG”,
		“ES”
	]
}

```

Ao cadastrar a região de atuação com sucesso, a aplicação responderá com status `201 (created)` e a estrutura de dados da região.