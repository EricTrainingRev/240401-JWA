package org.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.revature.TestRunner;

public class WikiSteps {

    /*
     * These steps are defined in the WikiSteps.feature file in the resources folder
     * 
     * the @Given, @When, @Then annotations are used to orgainze the test steps
     * 
     * test data is accessed from the TestRunner class
     */

    @Given("The User is on the Wikipedia homepage")
    public void the_user_is_on_the_wikipedia_homepage() {
        TestRunner.wikiHome.getHomepage();
    }
    @When("The User clicks the English link")
    public void the_user_clicks_the_english_link() {
        TestRunner.wikiHome.clickEnglishLink();
    }
    @Then("The User should be redirected to the English homepage")
    public void the_user_should_be_redirected_to_the_english_homepage() {
        TestRunner.wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
        Assert.assertEquals("Wikipedia, the free encyclopedia", TestRunner.driver.getTitle());
    }

    /*
        note the input from the examples table is referenced as its type between curly braces. The
        parameter type needs to match, name can be whatever you want
     */
    @When("The User enters {string} into the search bar")
    public void the_user_types_content_into_the_search_bar(String content) {
        TestRunner.wikiHome.enterTextIntoSearchBar(content);
    }
    @When("The User clicks the search button")
    public void the_user_clicks_the_search_button() {
        TestRunner.wikiHome.clickSearchButton();
    }
    @Then("The User should be redirected to the article page with {string} title")
    public void the_user_should_be_redirected_to_the_proper_page(String title) {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Wikipedia")));
        Assert.assertEquals(title, TestRunner.driver.getTitle());
    }
}
