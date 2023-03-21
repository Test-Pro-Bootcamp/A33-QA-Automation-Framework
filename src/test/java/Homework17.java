import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends LoginTests{

@Test
public void addSongToPlaylist() throws InterruptedException {

    String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

    navigateToPage();
    provideEmail("demo@class.com");
    providePassword("te$t$tudent");
    clickSubmit();
    Thread.sleep(2000);
    searchSong("Ketsa");
    clickViewAllBtn();
    selectFirstSongResult();
    clickAddToBtn();
    choosePlaylist();
    Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
}

public void searchSong(String name) throws InterruptedException {
    WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input [type= 'search']"));
    searchField.sendKeys(name);
    Thread.sleep(2000);
}
public void clickViewAllBtn()throws InterruptedException {
    WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
    viewAll.click();
    Thread.sleep(2000);
}

public void selectFirstSongResult() throws InterruptedException {
    WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
    firstSong.click();
    Thread.sleep(2000);
}
        public void clickAddToBtn() throws InterruptedException {
            WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
            addToBtn.click();
            Thread.sleep(2000);
        }

        public void choosePlaylist () throws InterruptedException {
            //We created a playlist named "Test Pro Playlist"
            WebElement playlist = driver.findElement(By.xpath("//section[@id=songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
            playlist.click();
            Thread.sleep(2000);

        }

        public String getAddToPlaylistSuccessMsg () {
            WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            return notification.getText();
        }
            public void navigateToPage()  {
                driver.get(url);
            }

            public void provideEmail(String email){
                WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
                emailField.clear();
                emailField.sendKeys();
            }

            public void providePassword (String password){
                WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
                passwordField.clear();
                passwordField.sendKeys(password);

            }

            public void clickSubmit () {
                WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
                submit.click();
            }

        }


