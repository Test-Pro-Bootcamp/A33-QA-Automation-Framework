import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    By provideEmail = By.cssSelector("[type='email']");
    By providePassword = By.cssSelector("[type ='password']");
    By submitButton = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public void submitButton() {
        driver.findElement(submitButton).click();
    }

    public void provideEmail(String email) {
        driver.findElement(provideEmail).sendKeys(email);

    }

    public void providePassword(String password) {
        driver.findElement(providePassword).sendKeys(password);
    }

    public void login() {
        provideEmail("guadalupe.medina@testpro.io");
        providePassword("DoingitBig23!");
        submitButton();
    }


}



