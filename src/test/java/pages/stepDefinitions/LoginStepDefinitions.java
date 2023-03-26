package pages.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinitions {


    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @After
    public void iCloseTheBrowser() {
        driver.quit();

    }

    @Given("I open Login Page")
    public void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String arg0) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));

    }

    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']]")));

    }

    @And("I submit")
    public void iSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));

    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());

    }


}