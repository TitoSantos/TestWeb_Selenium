package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import support.Utils;

public class CadastroPage extends Utils {

    WebDriver driver;

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

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selecionarTitulo(Integer tipo) {

        waitElementBePresent(titleM, 20);

        if (tipo == 1){
            driver.findElement(titleM).click();
        }else if (tipo == 2){
            driver.findElement(titleF).click();
        }
    }

    public void preencherNome(String nome) {
        driver.findElement(firstNameField).sendKeys(nome);
    }

    public void preencherSobrenome(String sobrenome) {
        driver.findElement(lastNameField).sendKeys(sobrenome);
    }

    public void preencherSenha(String senha) {
        driver.findElement(passwordField).sendKeys(senha);
    }

    public void selecionarDataAniversario(Integer dia, Integer mes, String ano) {
        Select select_day = new Select(driver.findElement(dayField));
        select_day.selectByIndex(dia);

        Select select_month = new Select(driver.findElement(monthField));
        select_month.selectByIndex(mes);

        Select select_year = new Select(driver.findElement(yearField));
        select_year.selectByValue(ano);
    }

    public void preencherAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void preencherCidade(String cidade) {
        driver.findElement(cityField).sendKeys(cidade);
    }

    public void selecionarEstado(String estado) {
        Select select_state = new Select(driver.findElement(stateField));
        select_state.selectByVisibleText(estado);
    }

    public void preencherZipcode(String zipcode) {
        driver.findElement(zipField).sendKeys(zipcode);
    }

    public void preencherTelefone(String telefone) {
        driver.findElement(phoneField).sendKeys(telefone);
    }

    public void clicarSubmitAccount() {
        clicarEmObjeto(submitButton, 10);
    }

    public void validaCadastro(String nome, String sobrenome) {
        waitElementBePresent(By.className("myaccount-link-list"), 20);
        String name_atual = driver.findElement(By.xpath("//span[contains(text(),'Tiago Martins')]")).getText();
        Assert.assertEquals(nome + " " +sobrenome, name_atual);
    }
}
