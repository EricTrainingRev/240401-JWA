package org.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHome {
    /*
        This driver is going to be provided by the Runner
     */
    private final WebDriver driver;

    /*
        FindBy works with the Page factory to assign elements to the given variables
     */
    @FindBy(id = "js-link-box-en")
    private WebElement englishLink;

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"search-form\"]/fieldset/button")
    private WebElement searchButton;

    @FindBy(tagName = "title")
    private WebElement title;

    public WikiHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getHomepage(){
        this.driver.get("https://www.wikipedia.org/");
    }

    public void clickEnglishLink(){
        this.englishLink.click();
    }

    public void enterTextIntoSearchBar(String input){
        this.searchBar.sendKeys(input);
    }

    public void clickSearchButton(){
        this.searchButton.click();
    }



}
