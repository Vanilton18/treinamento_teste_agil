package bdd;

import bdd.glue.WebDriverCreator;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

//Guidelines https://cucumber.io/docs/cucumber/
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"bdd/glue"},
        //https://cucumber.io/docs/cucumber/api/#tags
        tags = "@Sanity",
        publish = true,
        plugin = {"pretty","html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber-report/cucumber.xml"}

)
public class RunCucumberTest extends WebDriverCreator {

    @AfterClass
    public static void tearDownDriver() {
        driver.quit();
    }
}
