package org.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WikiHome {
    /*
        This driver is going to be provided by the Runner
     */
    private final WebDriver driver;

    /*
        FindBy works with the Page factory to assign elements to the given variables
     */
    @FindBy(id = "js-link-box-en") // id attribute of the web element is used to find it
    private WebElement englishLink;

    @FindBy(name = "search") // name attribute of the web element is used to find it
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"search-form\"]/fieldset/button") // xpath is used to find it
    private WebElement searchButton;

    @FindBy(tagName = "title") // tagName is used to find it
    private WebElement title;

    public WikiHome(WebDriver driver){
        // the driver is provided by the TestRunner
        this.driver = driver;

        // the PageFactory is provided by Selenium
        // the PageFactory is a tool that can handle initializing our Java representation of web elements
        // on the web page we are working on
        PageFactory.initElements(driver, this);
    }

    // this methods tells Selenium to go to the given URL
    public void getHomepage(){
        this.driver.get("https://www.wikipedia.org/");
    }


    // this method is used to click on the English link
    public void clickEnglishLink(){
        this.englishLink.click();
    }

    // this method is used to enter text into the search input
    public void enterTextIntoSearchBar(String input){
        this.searchBar.sendKeys(input);
        /*
            To recreate the above manually you would need the following code:
                WebElement search = this.driver.findElement(By.name("search"));
                search.sendKeys(input);
         */
    }

    // this method is used to click on the search button
    public void clickSearchButton(){
        this.searchButton.click();
    }



}
