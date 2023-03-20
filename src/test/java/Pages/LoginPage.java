package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css ="[type='email']")
    private WebElement enterEmailLocator;
    @FindBy(css = "[type='password']")
    private WebElement enterPasswordLocator;
    @FindBy(css ="button[type='submit']")
    private WebElement submitButtonLocator;

    //private By enterEmailLocator = By.cssSelector("[type='email']");
    //private By enterPasswordLocator = By.cssSelector("[type='password']");
    //private By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public LoginPage enterEmail(String email) {
        enterEmailLocator.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterPasswordLocator.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitButtonLocator.click();
        return this;
    }

    public void logIn(){
        enterEmail("vasilinapelo@gmail.com");
        enterPassword("vasilina230109!");
        clickSubmit();
    }

}
