package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {
    public static Actions actions = null;
    public static By emailField = By.cssSelector("[type='email']");
    public static By passwordField = By.cssSelector("[type='password']");
    public static By submitBtnLocator = By.cssSelector("[type = 'submit']");


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void loginPageTest() {
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

    public static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickSubmitBtn() {
        WebElement submitButtonElement = driver.findElement(submitBtnLocator);
        submitButtonElement.click();
    }

}