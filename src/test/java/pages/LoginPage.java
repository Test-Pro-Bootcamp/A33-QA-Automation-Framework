package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    //Locators
    By submitButton = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void provideEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
    public void logIn() {
        provideEmail("regniermandy@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }
}
