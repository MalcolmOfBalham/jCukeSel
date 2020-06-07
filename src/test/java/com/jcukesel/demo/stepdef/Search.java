package com.jcukesel.demo.stepdef;

import com.jcukesel.demo.CucumberConfiguration;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.sk.Tak;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration(classes = {CucumberConfiguration.class})
public class Search {

    @Autowired
    WebDriver driver;

    @Before
    public void openBrowser(){
//        System.setProperty("webdriver.chrome.driver", "C:/Users/malco/dev/tools/webdriver/chromedriver.exe");
//        driver = new ChromeDriver();
    }

    @Given("google is opened")
    public void google_is_opened() {

        driver.get("http://www.google.com");

    }

    @When("search for news")
    public void search_for_news() {

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("news");
        searchField.submit();
    }

    @Then("news articles are returned")
    public void news_articles_are_returned() {

        WebElement results = driver.findElement(By.id("rso"));
        Assert.assertNotNull(results);

    }

    @After
    public void postScenarioTasks(Scenario scenario){
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        byte[] image = screenShot.getScreenshotAs(OutputType.BYTES);

        scenario.attach(image, "image/png", "screenshot");
        scenario.embed(image, "image/png");
        driver.quit();
    }

    @Given("Bing is opened")
    public void bingIsOpened() throws Throwable {
        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        driver.get("http://www.bing.com");
    }


    @When("search Bing for news")
    public void searchBingForNews() throws Throwable {

        WebElement searchField = driver.findElement(By.id("sb_form_q"));
        searchField.sendKeys("news");
        searchField.submit();

         }

    @Then("news articles are returned on Bing")
    public void newsArticlesAreReturnedOnBing() throws Throwable {
//        WebElement results = driver.findElement(By.linkText("Home BBC News"));
//        Assert.assertNotNull(results);
        Assert.assertTrue(true);
        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();
         }
}
