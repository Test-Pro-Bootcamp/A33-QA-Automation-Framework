package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class LoginPage extends BasePage {


    By submitBtnLocator = By.cssSelector("[type = 'submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");


    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }


    public void loginPageTest() {
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

    }
    public void provideEmail(String email){
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }
    public void clickSubmitBtn(){
            driver.findElement(submitBtnLocator).click();
    }

}
