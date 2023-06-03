package stepDefinitions;

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
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    @After
    public void iCloseTheBrowser(){
        driver.quit();
    }


    @Given("I open Login Page")
    public void openLoginPage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");


        driver.get("https://bbb.testpro.io");

    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys(email);

    }
    @And("I enter password {string}")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys(password);

    }
    @And("I submit")
    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();

    }
    @Then("I am logged in")
    public void userIsLoggedIn(){
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }


}
