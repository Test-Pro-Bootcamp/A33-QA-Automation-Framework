import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    By iconlocator = By.cssSelector("button[data-test='like-btn']");

    @Test
    public void addSongToFavorites(){
        login();
        WebElement hearticon = wait.until(ExpectedConditions.elementToBeClickable(iconlocator));
        hearticon.click();
        String favoritebtntitle = hearticon.getAttribute("title");
        System.out.println(favoritebtntitle);
        Assert.assertTrue(favoritebtntitle.contains("Unlike"));
    }


}
