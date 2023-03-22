package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    @FindBy(className = "avatar")
    public WebElement avatar;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void isUserAvatarDisplayed() {
        Assert.assertTrue(avatar.isDisplayed());
    }

}
