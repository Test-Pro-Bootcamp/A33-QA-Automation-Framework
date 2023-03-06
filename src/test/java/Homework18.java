import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Homework18 extends BaseTest {
    @Test
    public void playSongTest() throws InterruptedException {
        logIn("regniermandy@gmail.com", "te$t$tudent");
        playSong();
        Assert.assertTrue(isSongPlaying());
}
    @Test
    public boolean isSongPlaying() {
        WebElement soundBarPlay = driver.findElement(By.cssSelector("[data-testid ='sound-bar-play']"));
        return soundBarPlay.isDisplayed();
    }

}
