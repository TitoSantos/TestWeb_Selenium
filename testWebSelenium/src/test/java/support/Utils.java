package support;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

import java.util.Random;

public class Utils extends RunCucumberTest {

    public void waitElementBePresent(By element, Integer time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getRadomEmail() {

        String email_init = "qacao_";
        String email_final = "@qacao.com.br";

        Random random = new Random();

        int minimo = 1;
        int maximo = 999999999;
        int resultado = random.nextInt(maximo-minimo) + minimo;

        return email_init+resultado+email_final;
    }

    public void clicarEmObjeto(By element, Integer time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
        System.out.println("Ocorreu um clique no elemento: "+element);
    }
}
