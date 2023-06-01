import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest {

    @Test

    public void ExplicitWaits() {

    }



        public static void providePassword() {
            WebElement providePassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='password']")));
            providePassword.sendKeys("DoingitBig23!");
        }


        public void submitButton(){
            WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='submit']")));
            submitButtonElement.click();

        }
        public void findSong(){
            WebElement findSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit'")));
            findSong.sendKeys();
        }
        public void clickViewAllButton() {
            WebElement clickViewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
            clickViewAllButton.click();

        }
        public void selectFirstSong() {
            WebElement selectFirstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
            selectFirstSong.click();

        }
        public void openPlaylist() {
            WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
            emptyPlaylist.click();
        }

        public void deletePlaylist() {
            WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
            deletePlaylistButton.click();
        }
        public String getNotificationMessage(){
            WebElement NotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return NotificationMessage.getText ();
        }
        public boolean songIsPlaying(){
            WebElement songIsPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='bars']")));
            return songIsPlaying.isDisplayed();
        }
        public boolean isDeletedPlaylistMsgDisplayed() {
            WebElement deletedPlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return deletedPlaylistMsg.isDisplayed();

        }
        @AfterMethod
        public void closeBrowser() {
            driver.quit();
        }
    }

    

