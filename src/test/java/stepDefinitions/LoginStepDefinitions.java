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
import pages.LoginPage;

import java.time.Duration;


public class LoginStepDefinitions{
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void iCloseTheBrowser () {
        driver.quit();
    }


    @Given ("I open Login Page")
    public void openLoginPage () {
        driver.get("https://bbb.testpro.io");
    }

    @When ("I  enter email {string}")
    public void iEnterEmail (String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And ("I enter password {string}")
    public void iEnterPassword (String password) {
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys(password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And ("I click submit")
    public void iClickSubmit () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
    }

    @Then ("I'm logged in")
    public void userIsLoggedIn () {
//        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isEmailFieldVisible();
    }

    @Then ("I see an error - Signin window  is shaking")
    public void seeAnError () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isLoginFormVisible();
    }


    @Then("I see an error - EmailField error")
    public void seeEmailFieldError(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailError();
    }
}
