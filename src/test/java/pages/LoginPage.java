package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
//attributes
//locators
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButton = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
//Constructor that takes a WebDriver object and passes it to its superclass constructor
//It's not initialized - we'll do that in the test classes
//    public LoginPage (WebDriver givenDriver) {
//        driver = givenDriver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//    }

//page methods
    public void provideEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSubmitBtn() {
        driver.findElement(submitButton).click();
    }
    public void login() {
        provideEmail("vera1077@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
