package Pages;

import net.bytebuddy.asm.Advice;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(css =".playlist:nth-child(3)")
            WebElement playlistElementLocator;
    @FindBy(css = "input[name='name']")
             WebElement inputPlaylistFieldLocator;
 //By playlistElementLocator = By.cssSelector(".playlist:nth-child(3)");
 //By inputPlaylistFieldLocator = By.cssSelector("input[name='name']");
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public HomePage doubleClickPlaylist(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(playlistElementLocator));
        //WebElement playlistElement = driver.findElement(playlistElementLocator);
        actions.doubleClick(playlistElementLocator).perform();
        return this;
    }

    public HomePage enterNewPlaylistName(){
        inputPlaylistFieldLocator.sendKeys(Keys.COMMAND + "a");
        inputPlaylistFieldLocator.sendKeys(Keys.DELETE);
        inputPlaylistFieldLocator.sendKeys(playlistName);
        inputPlaylistFieldLocator.sendKeys(Keys.ENTER);
        return this;

       // WebElement inputPlaylistField =wait.until(ExpectedConditions.elementToBeClickable
                //(inputPlaylistFieldLocator));
        //inputPlaylistField.sendKeys(Keys.COMMAND + "a");
        //inputPlaylistField.sendKeys(Keys.DELETE);
        //inputPlaylistField.sendKeys(playlistName);
        //inputPlaylistField.sendKeys(Keys.ENTER);
    }
    public boolean checkNewPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[text()= '" +playlistName+"']")));
        return playlistElement.isDisplayed();

    }

}
