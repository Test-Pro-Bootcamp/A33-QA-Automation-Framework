package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By emailFieldInput = By.cssSelector("[type = 'email']");
    By passwordFieldInput = By.cssSelector("[type = 'password']");
    By submitButton = By.cssSelector("button[type = 'submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideEmail(String email) {
        driver.findElement(emailFieldInput).sendKeys(email);
    }

    public void providePassword(String password) {
        driver.findElement(passwordFieldInput).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void login() {
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickSubmitButton();
    }
}
