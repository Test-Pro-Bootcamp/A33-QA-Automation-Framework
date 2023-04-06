package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void iCloseTheBrowser() {
        driver.quit();
    }
    @Given("I am logged in the Koel")
    public void iAmLoggedInKoel() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://bbb.testpro.io");
        loginPage.provideEmail("test@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Thread.sleep(2500);
    }
    @Given("I open Login Page")
    public void openLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isEmailFieldVisible();
    }
}