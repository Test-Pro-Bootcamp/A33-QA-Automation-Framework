package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;


import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I open Login Page")
    public void s1openLoginPage(){
        driver.get("https://bbb.testpro.io/#!/login");
    }

    @When("I enter email {string}")
    public void s2enterEmail(String email){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(email);
    }

    @And("I enter password {string}")
    public void s3enterPassword(String pass){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword(pass);
    }

    @And("I click submit")
    public void s4clickSubmitBtn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }

    @And("I am logged in")
    public void s5userIsLoggedIn(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserAvatarDisplayed().isDisplayed());
    }

    @After
    public void iCloseTheBrowser(){
        driver.quit();
    }
}
