Feature: Validar dados do produto selecionado

  @validarDados
  Scenario: Deve fazer busca
    Given acessar o menu dresses
    And selecionar o produto Printed Dress e abrir a pagina de detalhes do produto
    Then validar os valores exibidos no quadro Data Sheet


  @comprarProduto
  Scenario: Realizar a compra de um produto
    Given pesquisar produto
    And colocar produto no carrinho
    Then finalizar compra