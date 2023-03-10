import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    By playlistlocator = By.cssSelector("li[class='playlist playlist']");
    By inputselector = By.cssSelector("input[name='name']");
    String newplaylistname = "Test PRO";
/*
    @Test
    public void renamePlaylist(){
        login();
        doubleClickOnPlaylist();
        typeNewName();
        successMessage();
    }

    public void doubleClickOnPlaylist(){
        Actions action = new Actions(driver);
        WebElement firstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(playlistlocator));
        action.doubleClick(firstPlaylist).perform();
    }
    public void typeNewName(){
        WebElement firstPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(inputselector));
        firstPlaylist.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        firstPlaylist.sendKeys(newplaylistname);
        firstPlaylist.sendKeys(Keys.ENTER);
    }
    public void successMessage(){
        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='success show']")));
        System.out.println(msg.getCssValue("Visibility"));
        Assert.assertTrue(msg.getCssValue("Visibility").equals("visible"));
    }


 */
}
