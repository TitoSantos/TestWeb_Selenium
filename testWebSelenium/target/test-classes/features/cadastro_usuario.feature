#language: pt

  @cadastro
  Funcionalidade: Cadastro de usuário
    Eu como usuário
    Quero me cadastrar no site
    Para poder efetuar compras

  @cadastro-sucesso
  Cenario: Cadastrar novo usuário com sucesso
    Dado que estou na tela de login
    E acesso o cadastro de usuario
    Quando eu preencho o fomulario de cadastro
    E clico em registrar
    Então vejo a area logada do site
