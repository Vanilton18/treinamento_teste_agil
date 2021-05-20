package bdd.glue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StepDefinitions extends WebDriverCreator {

    @When("Preencho o vértice {int} com {string}")
    public void preencho_o_vértice_com(Integer vertice, String string) {
        driver.findElement(By.name("V"+vertice)).sendKeys(string);
    }

    @When("Clico no botão identificar")
    public void clico_no_botão_identificar() {
        driver.findElement(By.xpath("//input[@value='Identificar']")).click();
    }
    @Then("Devo visualizar o resultado de triângulo {string}")
    public void devo_visualizar_o_resultado_de_triângulo(String string) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]")));
        assertEquals(driver.findElement(By.xpath("//div[4]")).getText(),"Equilátero");
    }

    @When("Preencho triângulo")
    public void preencho_triângulo(io.cucumber.datatable.DataTable dataTableTriangulo) {
        for (Map<String, String> linha : dataTableTriangulo.asMaps()) {
            String vertice = linha.get("vertice");
            String valor = linha.get("valor");
            driver.findElement(By.name("V"+vertice)).sendKeys(valor);
        }
    }

}
