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


@RunWith(Cucumber.class) // This tells Junit Cucumber will be used to run the tests associated with this runner
@CucumberOptions(
        // this tells Cucumber where to find the feature files
        features = "classpath:features",
        // this tells Cucumber where to find the step definitions
        glue = "org.revature.steps",
        // this tells Cucumber where to create a test report
        plugin = {"pretty","html:src/test/resources/reports/html-reports.html"}
)
public class TestRunner {

    // the WebDriver is how Selenium interacts with the browser
    public static WebDriver driver;

    // the WebDriverWait is how we tell Selenium to wait for things to load or for conditions to be met
    public static WebDriverWait wait;

    // the WikiHome is a Page Object Model (POM) that represents a web page we want to interact with programatically
    public static WikiHome wikiHome;

    // This setup method is controlled by the testing software
    // it allows for the resources to be initialized before any tests are run
    @BeforeClass
    public static void setup(){
//        usingWebDriverManager();
        manualSetup();

        // make sure to manaully or automatically set up the driver data before initializing the field
        driver = new ChromeDriver();

        // the wait is how we tell Selenium to wait for things to load or for conditions to be met
        wait = new WebDriverWait(driver, 1);

        // the WikiHome is a Page Object Model (POM) that represents a web page we want to interact with programatically
        wikiHome = new WikiHome(driver);
    }

    // this teardown method is also controlled by the testing software
    // this closes the driver so we don't have to manually kill it
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    // as of 4/5/2024 this version of the WebDriverManager only works with Chrome version 114 and below
    public static void usingWebDriverManager(){
        WebDriverManager.chromedriver().setup();
    }


    // For Selenium to actually access the driver software the driver has to be loaded into the code
    // and a property Selenium uses has to be set
    public static void manualSetup(){
        // first step is to create a File object that references the driver software you need
        File chromedriver = new File("src/test/resources/chromedriver.exe");
        // Selenium uses this system property to actually access the driver software
        System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());

    }

}
