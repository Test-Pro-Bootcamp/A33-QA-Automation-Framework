import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomeWork21 extends BaseTest {


    private CharSequence playlistName;

    @Test
    public void renamePlaylist()  {
      //GIVEN
        String playlistName = "JAMS";
        String launchBrowser = "BaseURL";
        String provideEmail = "guadalupe.medina@testpro.io";
        String providePassword= "DoingitBig23!";
        provideEmail(provideEmail);
        providePassword(providePassword);
        submitButton();
       //WHEN

        launchBrowser();
        doubleClickChoosePlaylist();
        enterPlaylistName();

        // THEN
        Assert.assertTrue(doesPlayListExit());
    }

    private void launchBrowser() {
    }




    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector("playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).perform();

    }

    private void enterPlaylistName() {
        WebElement playlistInputField = (WebElement) driver.findElements(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));

        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);


    }

    public boolean doesPlayListExit() {
        WebElement playlistElement = driver.findElement(By.xpath("//e[text()= ' " + playlistName + "']"));
        return playlistElement.isDisplayed();


    }

   
    }







