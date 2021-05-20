package bdd.glue;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCreator extends TestCase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static DesiredCapabilities capacidade;
    public static Actions action;


    public WebDriver getDriver(){
        return driver;
    }
}

