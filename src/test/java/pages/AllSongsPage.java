package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllSongsPage extends BasePage {


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public List displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        return songList;
    }
}
