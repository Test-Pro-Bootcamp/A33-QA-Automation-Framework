package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    By emailFieldLocator = By.cssSelector("[type='email']");

    By passwordFieldLocator = By.cssSelector("[type='password']");

    By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public void provideEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
    }

    public void providePassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
    }

    public void login(){
        provideEmail("demo@TestPro30");
        providePassword("testpro123!");
        clickSubmitBtn ();

    }

    @FindBy(css = "[type='email']")
    public WebElement emailField;
    @FindBy(css = "[type='password']")
    public WebElement passwordField;
    @FindBy(css = "[type='submit']")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void provideEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        loginButton.click();
    }

    public void isEmailFieldVisible() {
        Assert.assertTrue(emailField.isDisplayed());
    }

}
