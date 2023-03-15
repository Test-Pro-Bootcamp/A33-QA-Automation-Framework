package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By playlistlocator = By.cssSelector("li[class='playlist playlist']");
    By inputselector = By.cssSelector("input[name='name']");
    String newplaylistname = "Test PRO";
    public String playlistname="Test";
    public String xpathplaylist="//a[text()=' ']";

    public String cssselector;
    public HomePage clickOnDeleteBtn() {
        WebElement deletebtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deletebtn.click();
        return this;
    }

    public HomePage clickOnPlaylist() {
        WebElement firstplaylist = driver.findElement(By.xpath(xpathplaylist.replace(" ",playlistname)));
        System.out.println(firstplaylist);
        firstplaylist.click();
        return this;

    }
    public HomePage createPlaylist() {
        WebElement playlistbtn = driver.findElement(By.cssSelector("i[title='Create a new playlist']"));
        playlistbtn.click();
        WebElement playlistcontextmenu = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        playlistcontextmenu.click();
        WebElement inputplaylistname = driver.findElement(By.cssSelector("input[name='name']"));
        inputplaylistname.sendKeys(playlistname);
        inputplaylistname.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage doubleClickOnPlaylist(){
        Actions action = new Actions(driver);
        WebElement firstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(playlistlocator));
        action.doubleClick(firstPlaylist).perform();
        return this;
    }
    public HomePage typeNewName(){
        WebElement firstPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(inputselector));
        firstPlaylist.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        firstPlaylist.sendKeys(newplaylistname);
        firstPlaylist.sendKeys(Keys.ENTER);
        return this;

    }
    public HomePage successMessage(){
        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='success show']")));
        System.out.println(msg.getCssValue("Visibility"));
        Assert.assertTrue(msg.getCssValue("Visibility").equals("visible"));
        return this;
    }
}
