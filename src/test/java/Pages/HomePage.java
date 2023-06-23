package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean navigateToHomePage(){
        WebElement successLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        return successLogin.isDisplayed();
    }
}
