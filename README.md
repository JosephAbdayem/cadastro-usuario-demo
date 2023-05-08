- # Cadastro de Usuário 💻👥🔝

Seja bem-vindo(a) ao projeto de Cadastro de Usuário! Nesta aplicação, é possível cadastrar usuários e vincular suas habilidades. A aplicação possui validações de integridade de dados nos campos nome, e-mail, data de nascimento e endereço.
## Tecnologias utilizadas 🚀
- Java
- SpringBoot
- JUnit
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

```arduino

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

```arduino

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