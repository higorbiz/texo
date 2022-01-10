package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.ValidarDadosDoProdutoSelecionadoPage;

import java.awt.*;


public class ValidarDadosDoProdutoSelecionadoStep {

    ValidarDadosDoProdutoSelecionadoPage page = new ValidarDadosDoProdutoSelecionadoPage();

    @Given("acessar o menu dresses")
    public void acessarOMenuDresses() {
        page.acessarMenuDress();
    }

    @And("selecionar o produto Printed Dress e abrir a pagina de detalhes do produto")
    public void selecionarOProdutoPrintedDressEAbrirAPaginaDeDetalhesDoProduto() throws AWTException, InterruptedException {
        page.selecionarProduto();
    }

    @Then("validar os valores exibidos no quadro Data Sheet")
    public void validarOsValoresExibidosNoQuadroDataSheet() {
        page.validarDataSheet();
    }

    @Given("pesquisar produto")
    public void pesquisarProduto() {
        page.pesquisarProduto();
    }

    @And("colocar produto no carrinho")
    public void colocarProdutoNoCarrinho() throws InterruptedException {
        page.colocarProdutoNoCarrinho();
    }

    @Then("finalizar compra")
    public void finalizarCompra() throws InterruptedException {
        page.finalizarCompra();
    }

}
