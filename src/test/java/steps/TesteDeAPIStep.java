package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.TesteDeAPIPage;

public class TesteDeAPIStep {
    TesteDeAPIPage page = new TesteDeAPIPage();

    @Given("^enviar um GET pesquisando pelo usuario \"([^\"]*)\"$")
    public void enviarUmGETPesquisandoPeloUsuario(String arg0) {
        page.enviaGetValidaNome(arg0);
    }

    @Then("^validar o statuscode \"([^\"]*)\" e o email \"([^\"]*)\" retornado$")
    public void validarOStatuscodeEOEmailRetornado(String arg0, String arg1) {
        page.enviaGetValidaStatusEEmail(arg0, arg1);
    }
}
