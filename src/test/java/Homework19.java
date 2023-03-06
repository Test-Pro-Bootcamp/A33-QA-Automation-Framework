import org.openqa.selenium.By;
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
    choosePlaylist();
    clickDeletePlaylistBtn();
    Assert.assertTrue(confirmNotification().contains("Deleted playlist"));
}


        public void choosePlaylist() throws InterruptedException {
    WebElement clickPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
    clickPlaylist.click();
    Thread.sleep(1000);
}
        public void clickDeletePlaylistBtn(){
        WebElement deletePlaylistClick = driver.findElement
                (By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']"));
        deletePlaylistClick.click();
        }

        public String confirmNotification() {
            WebElement messageDelete = driver.findElement(By.cssSelector("div.success.show"));
            return messageDelete.getText();
        }

  }

















