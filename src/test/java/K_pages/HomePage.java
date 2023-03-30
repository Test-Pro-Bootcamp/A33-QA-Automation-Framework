package K_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    WebDriver driver;
    WebDriverWait wait;
    //    locators
    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage (WebDriver givenDriver) {
        super(givenDriver);

    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

}
