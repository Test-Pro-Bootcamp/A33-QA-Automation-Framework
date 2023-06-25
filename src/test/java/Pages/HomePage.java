package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean navigateToHomePage(){
        WebElement successLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        return successLogin.isDisplayed();
    }
    public boolean navigateLoginPage(){
        WebElement unableToLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='logo']")));
        return unableToLogin.isDisplayed();
    }
    public boolean navigateLoginPageError(){
        WebElement unableToLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mac nprogress-busy']")));
        return unableToLogin.isDisplayed();
    }
        public boolean verifyAlertMessage( String expectedMessage) {
            try {
                Alert alert = driver.switchTo().alert();
                String actualMessage = alert.getText();
                System.out.println("Actual Alert Message: " + actualMessage);
                System.out.println("Expected Alert Message: " + expectedMessage);
                return actualMessage.equals(expectedMessage);
            } catch (NoAlertPresentException e) {
                // Handle the case when no alert is present
                return false;
            }
        }
}






