import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class LoginPage extends BasePage{
    WebDriverWait wait;
    //locators
    By enterEmailAddress = By.cssSelector(("[type = 'email']"));
    By passwordField = By.cssSelector(("[type='password']"));
    By submitButton = By.cssSelector(("[type='submit']"));
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
//        driver = givenDriver;
//        wait = new WebDriverWait(BasePage.driver,Duration.ofSeconds(10));
    }
//    public void logIn() {
//        enterEmail("linulya1411@gmail.com");
//        enterPassword("te$t$tudent");
//        clickSubmit();
//    }
    String email = "linulya1411@gmail.com";
    String password = "te$t$tudent";
    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(enterEmailAddress));
        emailElement.sendKeys("linulya1411@gmail.com");
    }
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordElement.sendKeys("te$t$tudent");
    }
    public void clickSubmit() {
        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitElement.click();
    }
}
