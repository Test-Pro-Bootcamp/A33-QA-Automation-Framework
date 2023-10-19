package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

By.firstPlaylist = By.cssSelector(".playlist:nth-child(3)");

By.playlistInputField = By.cssSelector("input[name='name']");

public class HomePage(WebDriver givenDriver) {
    super(givenDriven);
}


public void doubleClickFirstPlaylist(){
    doubleClickFirstPlaylist ();
}

public void enterPlaylistName(String playlistName) {
    WebElement playlistNameTextField = findElement(playlistInputField);
    playlistNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
    playlistNameTextField.sendKeys(playlistName);
    playlistNameTextField.sendKeys(Keys.ENTER);
}

public boolean doesPlaylistExist(String playlistName) {
    WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
    return playlistElement.isDisplayed();
}

    @FindBy(className = "avatar")
    public WebElement avatar;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void isUserAvatarDisplayed() {
        Assert.assertTrue(avatar.isDisplayed());
    }

}
