package pages;

import core.BasePage;
import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class ValidarDadosDoProdutoSelecionadoPage extends BasePage {

    public void acessarMenuDress() {
        DriverFactory.getDriver().get("http://automationpractice.com");
        esperaExplicita("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a");
        clicarBotao(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
    }

    public void selecionarProduto() throws AWTException, InterruptedException {
        esperaExplicita("//*[@id='center_column']/div[1]/div/div/span");
        executarJS("window.scrollBy(0,600)");
        clicarBotao(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a"));
    }

    public void validarDataSheet() {
        esperaExplicita("//*[@id='center_column']/div/div/div[3]/h1");
        executarJS("window.scrollBy(0,600)");
        String cottonText = obterTexto(By.xpath("//*[@class='table-data-sheet']/tbody/tr/td[contains(text(), 'Cotton')]"));
        String girlyText = obterTexto(By.xpath("//*[@class='table-data-sheet']/tbody/tr/td[contains(text(), 'Girly')]"));
        String colorfulText = obterTexto(By.xpath("//*[@class='table-data-sheet']/tbody/tr/td[contains(text(), 'Colorful Dress')]"));

        Assert.assertEquals("Cotton", cottonText);
        Assert.assertEquals("Girly", girlyText);
        Assert.assertEquals("Colorful Dress", colorfulText);

    }

    public void pesquisarProduto() {
        DriverFactory.getDriver().get("http://automationpractice.com");
        escrever(By.xpath("//*[@id='search_query_top']"), "Blouse");
        clicarBotao(By.xpath("//*[@id='searchbox']/button"));
    }

    public void colocarProdutoNoCarrinho() throws InterruptedException {
        esperaExplicita("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
        executarJS("window.scrollBy(0,600)");

        esperaExplicita("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
        mouseHover("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
        mouseHoverClick("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
    }

    public void finalizarCompra() throws InterruptedException {
        esperaExplicita("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
        clicarBotao(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span"));

        esperaExplicita("//*[@id='cart_title']");
        executarJS("window.scrollBy(0,600)");
        clicarBotao(By.xpath("//*[@id='center_column']/p[2]/a[1]/span"));
        Assert.assertEquals("AUTHENTICATION", obterTexto(By.xpath("//*[@id='center_column']/h1")));

    }

}
