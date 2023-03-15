package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[type='submit']")
    static
    WebElement submitButton;

    @FindBy(css="[type='email']")
    static
    WebElement emailField;

    @FindBy(css="type='password']")
    static
    WebElement passwordField;



    public static void provideEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);
        return this;
    }

    public static void providePassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);
        return this;
    }

    public static void clickSubmit() {
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
        return this;
    }

    public void logIn() {
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");
        //AND user clicks a submit button

        clickSubmit();
    }


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);

    }

}
