- # Cadastro de Usuário 💻

Seja bem-vindo(a) ao projeto de Cadastro de Usuário! Nesta aplicação, é possível cadastrar usuários e vincular suas habilidades. A aplicação possui validações de integridade de dados nos campos nome, e-mail, data de nascimento e endereço.
## Tecnologias utilizadas 🚀
- Java
- SpringBoot
- JUnit

## Dependências 🛠️
- **spring-boot-starter-data-jpa** : dependência que fornece as classes necessárias para integração com o JPA (Java Persistence API), que permite a persistência de objetos Java em um banco de dados relacional.
- **spring-boot-starter-web** : dependência que fornece as classes necessárias para criação de aplicativos web Spring MVC.
- **spring-boot-starter-validation** : dependência que fornece as classes necessárias para validação de dados nos objetos de domínio do Spring.
- **spring-boot-devtools** : dependência que fornece ferramentas de desenvolvimento, como recarregamento automático (hot reloading) da aplicação quando há mudanças no código.
- **javax.persistence-api** : dependência que fornece as interfaces do JPA.
- **h2** : dependência que fornece um banco de dados relacional embutido para uso em ambiente de desenvolvimento.
- **javax.el-api**  e **javax.el** : dependências que fornecem as classes necessárias para a Expression Language (EL), que permite a avaliação de expressões no JSP e JSF.
- **spring-boot-starter-test** : dependência que fornece as classes necessárias para testes de unidade, como JUnit e Mockito.
- **junit** : dependência que fornece as classes necessárias para testes de unidade com o JUnit.

## Como rodar a aplicação ▶️

Antes de começar, é necessário ter as seguintes ferramentas instaladas em sua máquina:
- Java 8 ou superior
- Maven

Para rodar a aplicação, siga os passos abaixo:
1. Clone este repositório em sua máquina:

```bash
git clone https://github.com/JosephAbdayem/cadastro-usuario-demo.git
```

1. Entre na pasta do projeto:

```bash
cd cadastro-usuario-demo
```

1. Execute o comando para rodar a aplicação:

```bash
mvn spring-boot:run
```

Pronto! A aplicação estará rodando em [http://localhost:8080](http://localhost:8080/)  .
## Funcionalidades da aplicação ⚙️
- Cadastro de usuário: é possível cadastrar um novo usuário com nome, e-mail, data de nascimento e endereço.
- Cadastro de habilidades: é possível vincular habilidades a um usuário cadastrado.
- Validação de integridade de dados: a aplicação realiza validações nos campos nome, e-mail, data de nascimento e endereço para garantir que os dados estejam corretos e coerentes.
## Como contribuir 💪
1. Faça um fork deste repositório.
2. Crie uma branch para a sua feature: `git checkout -b minha-feature`
3. Faça as suas alterações e commit: `git commit -m 'Minha feature'`
4. Push para a branch: `git push origin minha-feature`
5. Abra um pull request para este repositório.
## Executando os testes 🧪

Os testes unitários estão na pasta `test` e são em sua maioria JUnit. Para executá-los, basta rodar o seguinte comando no terminal dentro da pasta raiz do projeto:

```bash
mvn test
```

## Estrutura do projeto 📁

A estrutura do projeto é baseada em duas entidades principais:
- **Usuario:**  representa um usuário cadastrado na aplicação, com nome, e-mail, data de nascimento e endereço.
- **Habilidade:**  representa uma habilidade vinculada a um usuário cadastrado na aplicação.

As classes e interfaces relacionadas a essas entidades são as seguintes:
- **UsuarioController:**  é a classe responsável por receber as requisições HTTP e gerenciar as ações relacionadas aos usuários, como cadastrar um novo usuário, vincular habilidades a um usuário, etc.
- **UsuarioRepository:**  é a interface que define os métodos para acessar o banco de dados de usuários.
## Êxitos mínimos 🎯

Para rodar essa aplicação, você precisa ter instalado em sua máquina o **Java 8 ou superior**  e o **Maven** . Certifique-se de que essas ferramentas estejam instaladas corretamente antes de iniciar a aplicação.

A aplicação possui validações de integridade de dados nos campos nome, e-mail, data de nascimento e end