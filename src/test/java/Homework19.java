import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        setupClass();

        navigateToPage();
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmit();


        createPlaylist();
        choosePlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(confirmNotification().contains("Deleted playlist"));
//      closeBrowser();
    }

    public void createPlaylist() throws InterruptedException {
        WebElement newPlaylistName = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        newPlaylistName.click();
        WebElement clickPlusButton = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        clickPlusButton.click();
        WebElement typeNewName = driver.findElement(By.cssSelector("[name='name']"));
        typeNewName.sendKeys("TestNewPlaylist", Keys.RETURN);
        Thread.sleep(2000);

    }

    public void choosePlaylist() throws InterruptedException {
        WebElement clickPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        clickPlaylist.click();
        Thread.sleep(2000);
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylistClick = driver.findElement
                (By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']"));
        deletePlaylistClick.click();
        Thread.sleep(2000);
    }

    public String confirmNotification() throws InterruptedException {
        WebElement messageDelete = driver.findElement(By.cssSelector("div.success.show"));
        return messageDelete.getText();

    }

}
