package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    @FindBy(css = "input[type='email']")
    private WebElement emailFieldLocator;
    @FindBy(css = "input[type='password']")
    private WebElement passFieldLocator;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButtonLocator;

    @FindBy(css = "a[id='hel']")
    private WebElement registrationBtnLocator;

    //By emailFieldLocator = By.cssSelector("input[type='email");
    //By passFieldLocator = By.cssSelector("input[type='password");
    //By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage inputEmail(String email) {
        emailFieldLocator.sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String pass) {
        passFieldLocator.sendKeys(pass);
        return this;
    }

    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }

    public void clickRegiBtn() {
        registrationBtnLocator.click();
    }

    public String getkoelRegiPage() {
        return koelRegi;
    }

    public void logIn() {
        inputEmail(email);
        inputPassword(password);
        clickSubmitBtn();
        wait.until(ExpectedConditions.urlToBe(koelHome));
    }

    public void inputLogIn(String mail, String pass) {
        inputEmail(mail);
        inputPassword(pass);
        clickSubmitBtn();
        wait.until(ExpectedConditions.urlToBe(koelHome));
    }


}
