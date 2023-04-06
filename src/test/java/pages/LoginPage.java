package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "[type = 'submit']")
    private WebElement submitBtnLocator;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void loginPageTest() {
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

    public void loginWithInvalidEmail(){
        provideEmail("testNG@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
    public void loginWithInvalidPassword(){
        provideEmail("test@test.com");
        providePassword("testStudent");
        clickSubmitBtn();
    }

    public static void navigateToPage() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Thread.sleep(2000);
    }

    public LoginPage provideEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
       passwordField.sendKeys(password);
       return this;
    }

    public LoginPage clickSubmitBtn() {
        submitBtnLocator.click();
        return this;

    }
    public void isEmailFieldVisible(){
        Assert.assertTrue(emailField.isDisplayed());
    }

    public void loginApplication(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitBtnLocator.click();
    }
}