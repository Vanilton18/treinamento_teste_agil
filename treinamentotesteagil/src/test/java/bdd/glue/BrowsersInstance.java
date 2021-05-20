package bdd.glue;

import Utils.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowsersInstance extends WebDriverCreator {

    @After
    public void finalizar(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "png","image");
        }
        if(capacidade != null){
            capacidade.setCapability("resetKeyboard", true);
        }
        driver.navigate().to("http://vanilton.net/triangulo");

    }

    public void initManage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @SuppressWarnings("static-access")
    @Given("Estou no navegador {string}")
    public void que_estou_no_navegador(String navegador) throws Throwable {
        String ParseNavegador = navegador.toUpperCase();
        Long timeout = Long.valueOf(10);
        if (getDriver() == null) {
            switch (Browser.valueOf(ParseNavegador)) {
                case CHROME:
                    driver = new ChromeDriver();
                    action= new Actions(driver);
                    wait = new WebDriverWait(driver, 20);
                    this.initManage();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    action= new Actions(driver);
                    wait = new WebDriverWait(driver, timeout);
                    this.initManage();
                    break;
                default:
                    break;
            }
        }
    }

    @Given("Acesso o site {string}")
    public void estou_no_site(String string) {
        driver.get(string);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}