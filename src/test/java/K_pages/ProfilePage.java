package K_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    public ProfilePage (WebDriver givenDriver) {
        super(givenDriver);
    }

    //    locators
    @FindBy (css = "[data-testid='theme-card-jungle']")
    WebElement jungleTheme;
    @FindBy (css = "[data-testid='theme-card-jungle'][class='theme selected']")
    WebElement verifySelectedJungleTheme;

    public boolean isJungleThemeSelected () {
        return verifySelectedJungleTheme.isSelected();
    }

    public ProfilePage chooseJungleTheme () {
      jungleTheme.click();
        return this;
    }



}
