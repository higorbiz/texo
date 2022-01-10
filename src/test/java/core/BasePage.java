package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static core.DriverFactory.getDriver;

public class BasePage {
    /********* TextField e TextArea ************/

    public void escrever(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escrever(String id_campo, String texto){
        escrever(By.id(id_campo), texto);
    }

    public String obterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    /********* Radio e Check ************/

    public void clicarRadio(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarRadio(String id) {
        clicarRadio(By.id(id));
    }

    public boolean isRadioMarcado(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void clicarCheck(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isCheckMarcado(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/

    public void selecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresCombo(String id) {
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoesCombo(String id){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for(WebElement option: options) {
            if(option.getText().equals(opcao)){
                return true;
            }
        }
        return false;
    }

    public void selecionarComboPrime(String radical, String valor) {
        clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
        clicarRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
    }

    /********* Botao ************/

    public void clicarBotao(String id) {

        clicarBotao(By.id(id));
    }

    public String obterValueElemento(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    public void clicarBotao(By by){
        getDriver().findElement(by).click();
    }

    /********* Link ************/

    public void clicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    /********* Textos ************/

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    /********* Alerts ************/

    public String alertaObterTexto(){
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String alertaObterTextoENega(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertaEscrever(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /********* Frames e Janelas ************/

    public void entrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void sairFrame(){
        getDriver().switchTo().defaultContent();
    }

    public void trocarJanela(String id) {
        getDriver().switchTo().window(id);
    }

    /************** JS *********************/

    public Object executarJS(String cmd) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd);
    }

    public void scrollDown() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    }

    /************** Espera *********************/
    public void esperaExplicita(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void esperaImplicita() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /************** Mouse Hover *********************/
    public void mouseHover(String xpath) {
        Actions action = new Actions(getDriver());
        WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
        action.moveToElement(element).perform();
    }

    public void mouseHoverClick(String xpath) {
        Actions action = new Actions(getDriver());
        WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
        action.moveToElement(element).click().perform();
    }

}
