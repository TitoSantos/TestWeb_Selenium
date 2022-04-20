package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import runner.RunCucumberTest;
import support.Utils;

public class CadastroPage extends RunCucumberTest {

    private By titleM = By.id("id_gender1");
    private By titleF = By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By dayField = By.id("days");
    private By monthField = By.id("months");
    private By yearField = By.id("years");
    private By addressField = By.id("address1");
    private By cityField = By.id("city");
    private By stateField = By.id("id_state");
    private By zipField = By.id("postcode");
    private By phoneField = By.id("phone_mobile");
    private By submitButton = By.id("submitAccount");

    public void selecionarTitulo(Integer tipo) {

        Utils.waitElementBePresent(titleM, 20);

        if (tipo == 1){
            getDriver().findElement(titleM).click();
        }else if (tipo == 2){
            getDriver().findElement(titleF).click();
        }
    }

    public void preencherNome(String nome) {
        getDriver().findElement(firstNameField).sendKeys(nome);
    }

    public void preencherSobrenome(String sobrenome) {
        getDriver().findElement(lastNameField).sendKeys(sobrenome);
    }

    public void preencherSenha(String senha) {
        getDriver().findElement(passwordField).sendKeys(senha);
    }

    public void selecionarDataAniversario(Integer dia, Integer mes, String ano) {
        Select select_day = new Select(getDriver().findElement(dayField));
        select_day.selectByIndex(dia);

        Select select_month = new Select(getDriver().findElement(monthField));
        select_month.selectByIndex(mes);

        Select select_year = new Select(getDriver().findElement(yearField));
        select_year.selectByValue(ano);
    }

    public void preencherAddress(String address) {
        getDriver().findElement(addressField).sendKeys(address);
    }

    public void preencherCidade(String cidade) {
        getDriver().findElement(cityField).sendKeys(cidade);
    }

    public void selecionarEstado(String estado) {
        Select select_state = new Select(getDriver().findElement(stateField));
        select_state.selectByVisibleText(estado);
    }

    public void preencherZipcode(String zipcode) {
        getDriver().findElement(zipField).sendKeys(zipcode);
    }

    public void preencherTelefone(String telefone) {
        getDriver().findElement(phoneField).sendKeys(telefone);
    }

    public void clicarSubmitAccount() {
        Utils.clicarEmObjeto(submitButton, 10);
    }

    public void validaCadastro(String nome, String sobrenome) {
        Utils.waitElementBePresent(By.className("myaccount-link-list"), 20);
        String name_atual = getDriver().findElement(By.xpath("//span[contains(text(),'Tiago Martins')]")).getText();
        Assert.assertEquals(nome + " " +sobrenome, name_atual);
    }
}
