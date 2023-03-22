import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void testRenamePlayList() {
        String namePlayLiat = "My music";
        getEmail("ponypony123@gmail.com");
        getPassword("Testtesttest123123$$");
        loginUser();
        doubleClickOnPlaylist();
        enterPlaylistName(namePlayLiat);
        Assert.assertTrue(assertNotificationText());
    }

    public boolean assertNotificationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success"))).isDisplayed();
    }

    public void enterPlaylistName(String playlistName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        playlistInputField.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private void doubleClickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playlist playlist']")));
        new Actions(driver)
                .doubleClick(playlist)
                .perform();
    }
}