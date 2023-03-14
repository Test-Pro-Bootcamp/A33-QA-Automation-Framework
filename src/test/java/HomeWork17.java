import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;




    public class HomeWork17 extends BaseTest {

        @Test
        public void addSongToPlaylist() throws InterruptedException {

            String newSongAddedNotificationText = "Add 1 song into";


            navigateToPage();
            provideEmail("guadalupe.medina@testpro.io");
            providePassword("DoingitBig23!");
            submitButton();
            searchSong("BossStatus");
            clickViewAllBtn();
            selectFirstSongResults();
            clickAddToBtn();
            choosePlaylist("JAMS");

            Assert.assertTrue(isNotificationPopUpPresent());
        }

    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement clickViewAllBtn = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        clickViewAllBtn.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResults() throws InterruptedException {
        WebElement selectFirstSongResults = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        selectFirstSongResults.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }

//    public void createNewPlaylist() throws InterruptedException {
        public void choosePlaylist(String playlistName) throws InterruptedException {
            WebElement playlistNameElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text(),'"+playlistName+"')]"));
        playlistNameElement.click();
        Thread.sleep(2000);
    }


    public boolean isNotificationPopUpPresent() {
        WebElement newSongAddedNotificationText = driver.findElement(By.cssSelector("div.success.show"));
        return newSongAddedNotificationText.isDisplayed();
    }
}


