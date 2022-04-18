package steps;

import cucumber.api.java.es.Dado;
import pages.LoginPage;
import runner.RunCucumberTest;

public class LoginSteps extends RunCucumberTest {

    LoginPage loginPage = new LoginPage(driver);

    @Dado("^que estou na tela de login$")
    public void que_estou_na_tela_de_login() {
        loginPage.acessarTelaLogin();
    }

    @Dado("^acesso o cadastro de usuario$")
    public void acesso_o_cadastro_de_usuario() {
        loginPage.preencherCmpoEmail();
        loginPage.clicarNoBotaoCriarConta();
    }
}
