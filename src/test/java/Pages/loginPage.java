package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends basePage {
    By emailFieldInput = By.cssSelector("[type = 'email']");
    By passwordFieldInput = By.cssSelector("[type = 'password']");
     By submitButton = By.cssSelector("button[type = 'submit']");

    public loginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void provideEmail (String email){driver.findElement(emailFieldInput).sendKeys(email);}
    public void providePassword (String password){driver.findElement(passwordFieldInput).sendKeys(password);}
    public void clickSubmitButton(){driver.findElement(submitButton).click();}
    public void login(){
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickSubmitButton();
    }
 }
