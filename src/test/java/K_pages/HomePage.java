package K_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //    locators
    @FindBy (css = "img.avatar")
    WebElement userAvatarIcon;


    public HomePage (WebDriver givenDriver) {
        super(givenDriver);

    }

    public WebElement getUserAvatar () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) userAvatarIcon));
    }


}

