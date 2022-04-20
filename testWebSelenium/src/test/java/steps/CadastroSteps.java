package steps;

import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.CadastroPage;
import runner.RunCucumberTest;

public class CadastroSteps extends RunCucumberTest {

    CadastroPage cadastroPage = new CadastroPage();
    String nome = "Tiago";
    String sobrenome = "Martins";
    String senha = "S&rv&re123";

    @Quando("^eu preencho o fomulario de cadastro$")
    public void eu_preencho_o_fomulario_de_cadastro() {
        cadastroPage.selecionarTitulo(1);
        cadastroPage.preencherNome(nome);
        cadastroPage.preencherSobrenome(sobrenome);
        cadastroPage.preencherSenha(senha); //criar método para criar uma senha automática e randomica
        cadastroPage.selecionarDataAniversario(10, 8, "1985");
        cadastroPage.preencherAddress("Morgam street, 123");
        cadastroPage.preencherCidade("Tampa");
        cadastroPage.selecionarEstado("Florida");
        cadastroPage.preencherZipcode("88800");
        cadastroPage.preencherTelefone("714365784");
    }

    @Quando("^clico em registrar$")
    public void clico_em_registrar() {
        cadastroPage.clicarSubmitAccount();
    }

    @Então("^vejo a area logada do site$")
    public void vejo_a_area_logada_do_site() {
        cadastroPage.validaCadastro(nome, sobrenome);
    }

}
