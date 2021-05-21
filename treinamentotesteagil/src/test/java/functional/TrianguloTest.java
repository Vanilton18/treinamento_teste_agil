package functional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TrianguloTest {

    WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://vanilton.net/triangulo");
    }

    @Test
    public void verificarTipoEquilatero(){
        driver.findElement(By.name("V1")).sendKeys("3");
        driver.findElement(By.name("V2")).sendKeys("3");
        driver.findElement(By.name("V3")).sendKeys("3");
        driver.findElement(By.xpath("//input[@value='Identificar']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(.,'Equilátero')]")).isDisplayed());
    }

    @Test
    public void verificarTipoEscaleno(){
        driver.findElement(By.name("V1")).sendKeys("7");
        driver.findElement(By.name("V2")).sendKeys("8");
        driver.findElement(By.name("V3")).sendKeys("3");
        driver.findElement(By.xpath("//input[@value='Identificar']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(.,'Escaleno')]")).isDisplayed());
    }

    @Test
    public void verificarTipoIsosceles(){
        driver.findElement(By.name("V1")).sendKeys("8");
        driver.findElement(By.name("V2")).sendKeys("8");
        driver.findElement(By.name("V3")).sendKeys("3");
        driver.findElement(By.xpath("//input[@value='Identificar']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(.,'Isósceles')]")).isDisplayed());
    }

    @Test
    public void verificarComLetras(){
        driver.findElement(By.name("V1")).sendKeys("a");
        driver.findElement(By.name("V2")).sendKeys("a");
        driver.findElement(By.name("V3")).sendKeys("a");
        driver.findElement(By.xpath("//input[@value='Identificar']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(.,'Isósceles')]")).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
