import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() {
        String deletedPlaylistMsg = "Deleted playlist";

        login("demo@class.com", "te$t$tudent");
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }
    public void openPlaylist()  {
         WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
         emptyPlaylist.click();
        }
    public void clickDeletePlaylistBtn(){
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }
     public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
        }
}

