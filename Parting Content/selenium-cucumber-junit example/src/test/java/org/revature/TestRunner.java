package org.revature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.revature.pom.WikiHome;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "org.revature.steps",
        plugin = {"pretty","html:src/test/resources/reports/html-reports.html"}
)
public class TestRunner {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WikiHome wikiHome;

    @BeforeClass
    public static void setup(){
//        usingWebDriverManager();
        manualSetup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1);
        wikiHome = new WikiHome(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    public static void usingWebDriverManager(){
        WebDriverManager.chromedriver().setup();
    }

    public static void manualSetup(){
        File chromedriver = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());

    }

}
