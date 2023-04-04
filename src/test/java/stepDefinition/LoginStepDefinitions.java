package stepDefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import java.time.Duration;

public class LoginStepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final int TIME_IMPLICIT_WAIT = 7;
    private String submittedEmail = "";
    private String submittedPassword = "";

    @Given ("User opens the browser")
    public void openBrowser () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--remote-allow-origins=*","--disable-notifications","--incognito", "--start-maximized");
        driver = new ChromeDriver(optionsChrome);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_IMPLICIT_WAIT));
    }

    @And("User is on Login page")
    public void userOpenLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("User enters valid email {string}")
    public void userEnterEmail(String email) {
        submittedEmail = email;
        System.out.println("Login in with email: " + submittedEmail);
    }

    @And("User enters the valid password {string}")
    public void userEnterPassword(String password) {
        submittedPassword = password;
        System.out.println("Login in with password: " + submittedPassword);
    }

    @And("Clicks submit button")
    public void userSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithValidCredentials(submittedEmail, submittedPassword);
        System.out.println("Login in with email: " + submittedEmail + ", password: " + submittedPassword);
    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatar.isDisplayed());
        closeBrowser();
    }

    private void closeBrowser () {driver.close();}
}
