Feature: Enviar um GET para a API https://gorest.co.in/public-api/users pesquisando por Ronald Kessler

  @enviarGet
  Scenario Outline: Verificar statuscode e email retornado
    Given enviar um GET pesquisando pelo usuario "<usuario>"
    Then validar o statuscode "<statuscode>" e o email "<email>" retornado

    Examples:
      | usuario    | statuscode | email               |
      | aku cantik | active     | mbalu2069@gmail.com |