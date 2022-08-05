# Descrição da API

## Configurações iniciais

### XML

No arquivo pom.xml temos as configurações do projeto, onde estão a conexão com o apache, as dependências e os plug-ins.

### Aplication Properties

No arquivo aplication.properties temos as configurações de acesso ao banco de dados, onde temos a url de acesso, username, senha e a linguagem que conversará com o banco. Também temos uma correção de bug e uma configuração que, ao se modificar uma classe na aplicação, essa classe se altere no banco também.

Também foram adicionadas as configurações gerais dos clientes do aplicativo, onde temos o clientId e o client-secret que fazem a ligação com o sistema de login. Temos também a URI que redireciona para o login com a oauth2 e o nome do client. Em seguida encontra-se a URI de logout e a URI de redirect para a página inicial.

## Classes de Modelo

- Artigo: Definimos essa classe como uma tabela no banco e seus atributos como colunas. Nela temos os atributos pedidos para o artigo, seus construtores, getters, setters e o toString. Utilizamos a notação @Id para definirmos a chave primária, @GeneratedValue para auto-incrementar e @Column para as colunas da tabela.


## Classes Repositório

Nelas temos todos os métodos para buscar e recuperarmos dados das tabelas(classes) dentro do banco de dados.

- ArtigoRepository: temos buscas por filtragem de artigos publicados e por uma string que contém no título.


## Classes Controle

Nelas que temos os métodos GET, POST, DELETE, PUT etc onde podemos utilizar os métodos dos repositórios criados.

- ArtigoController: Para o artigo temos as opções de listagem de artigos em geral, por filtragem de palavras no título ou por id, inserção de artigos, atualização de artigos já existentes por id e remoção geral de artigos ou por id.


- HomeController: Controlador das páginas html, onde definimos a landing page como index.html


## Classes Segurança

- CognitoOidcLogoutSuccesHandler: Classe para realizar o logout.


- SecurityConfiguration: Classe para configuração da autorização e requests, login, logout e limpeza de autenticação e cookies.


## Templates

- index.html: Página inicial, onde fazemos o login para prosseguirmos à aplicação e temos o botão de listar.

- listar.html: Página de listagem de artigos, onde temos botão para edições e delete.

- editar.html: Página para edição de um artigo selecionado.

- criar.html: Págia para criação de um novo artigo.

## Testes

Para os testes foi usado a IDE pgAdmin para verificarmos o que está acontecendo no banco. Ao rodarmos a aplicação no Maven, as tabelas já foram criadas automaticamente no banco secauth criado, com suas colunas e chaves primárias e estrangeiras devidamente atribuidas.
Para inserirmos os dados, temos as páginas templates onde temos os campos para inserção no banco.