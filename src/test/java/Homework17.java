import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

   @Test
    public void addSongToPlaylist() throws InterruptedException {

       String newSongAddedNotificationText = "Added 1 song";

       setUpBrowser();;
       provideEmail ("jguy1@stny.rr.com");
       providePassword ("te$t$tudent");
       clickSubmit();
       searchSong("Algorithms");
       clickViewAllButton();
       selectFirstSongResult();
       clickAddToButton();
       choosePlaylist();

        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }


    public void searchSong(String songTitleKeyword) throws InterruptedException {
       WebElement searchField = driver.findElement(By.cssSelector("#searchForm > input[type=search]"));
       searchField.sendKeys(songTitleKeyword);
       Thread.sleep(3000);
    }

    public void clickViewAllButton() throws InterruptedException {
       WebElement viewAllSearchResults = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllSearchResults.click();
        Thread.sleep(3000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(3000);
    }

    public void clickAddToButton() throws InterruptedException {
       WebElement addToButton = driver.findElement(By.cssSelector("Button[class='btn-add-to']"));
       addToButton.click();
       Thread.sleep(3000);
    }

    public void choosePlaylist() throws InterruptedException {
       WebElement choosePlayList = driver.findElement(By.xpath("//section[@id ='songResultsWrapper']//li[contains(text(),'A33 playlist')]"));
        choosePlayList.click();
        Thread.sleep(3000);
    }

    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }

}

