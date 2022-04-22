package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import support.Utils;

public class MessagePage extends Utils {


    private By subject_field = By.id("id_contact");
    private By message_field = By.id("message");
    private By upload_field = By.id("fileUpload");
    private By email_field = By.id("email");
    private By submit_button = By.id("submitMessage");
    private By sent_alert = By.cssSelector("div[id='center_column'] > p");


    public void acessarMessage(){
        getDriver().get("http://automationpractice.com/index.php?controller=contact");
        Utils.waitElementBePresent(message_field, 20);
    }

    public void selecionaAssunto(String assunto) {
        Select select_assunto = new Select(getDriver().findElement(subject_field));
        select_assunto.selectByVisibleText(assunto);
    }

    public void preencheMensagem(String mensagem) {
        getDriver().findElement(message_field).sendKeys(mensagem);
    }
    public void uploadArquivo(String caminhoArquivo) {
        getDriver().findElement(upload_field).sendKeys(caminhoArquivo);
    }

    public void preencherCampoEmail(String email){
        getDriver().findElement(email_field).sendKeys(email);
    }

    public void clicarEmSubmit() {
        Utils.clicarEmObjeto(submit_button, 10);
    }

    public void validarEnvioMensagem(String texto_esperado) {
        String texto_atual = getDriver().findElement(sent_alert).getText();
        Assert.assertEquals("A mensagem está errada.",texto_esperado, texto_atual);
    }
}
