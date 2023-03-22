package pages.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class LoginStepDefinitions {


    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {

    }

    @After
    public void iCloseTheBrowser() {
        driver.quit();

    }

    @Given("I open browser")
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
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());

    }
}