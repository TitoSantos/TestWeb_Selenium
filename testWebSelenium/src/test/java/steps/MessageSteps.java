package steps;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.MessagePage;
import runner.Base;
import runner.RunCucumberTest;
import support.Utils;

public class MessageSteps extends RunCucumberTest {

    MessagePage messagePage = new MessagePage();

    @Dado("^que estou na tela de mensagens$")
    public void que_estou_na_tela_de_mensagens()  {
        getDriver(Base.Browser.CHROME);
        messagePage.acessarMessage();
    }

    @Dado("^preencho todos os campos$")
    public void preencho_todos_os_campos()  {
        messagePage.selecionaAssunto("Webmaster");
        messagePage.preencheMensagem("Minha mensagem.");
        messagePage.preencherCampoEmail(Utils.randomEmail());
        messagePage.uploadArquivo("C:\\projeto-web-selenium\\testWebSelenium\\MeuArquivo.txt");
    }

    @Quando("^clico em enviar mensagem$")
    public void clico_em_enviar_mensagem()  {
        messagePage.clicarEmSubmit();
    }

    @Então("^vejo mensagem enviada com sucesso$")
    public void vejo_mensagem_enviada_com_sucesso()  {
        messagePage.validarEnvioMensagem("Your message has been successfully sent to our team.");
    }
}
