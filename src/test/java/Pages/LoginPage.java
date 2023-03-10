package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    By submitbutton = By.cssSelector("button[type='submit']");
    By emaillocator = By.cssSelector("input[type='email']");
    By passwordlocator = By.cssSelector("input[type='password']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void enterEmail(String email) {
        WebElement emailfield = wait.until(ExpectedConditions.elementToBeClickable(emaillocator));
        emailfield.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordfield = wait.until(ExpectedConditions.elementToBeClickable(passwordlocator));
        passwordfield.sendKeys(password);
    }

    public void submit() {
        WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submitbutton));
        submitbtn.click();
    }

    public void login() {
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
    }

}
