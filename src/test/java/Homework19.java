import Pages.LoginPage;
import com.beust.jcommander.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    public String playlistname="Test";
    public String xpathplaylist="//a[text()=' ']";

    public String cssselector;
/*
   LoginPage loginpage = new LoginPage(driver);
    @Test
    public void deletePlaylist() {
        driver.get("https://bbb.testpro.io/#!/home");
        loginpage.login();
        createPlaylist();
        clickOnPlaylist();
        clickOnDeleteBtn();
        WebElement msg = driver.findElement(By.cssSelector("div[class='success show']"));
        System.out.println(msg.getCssValue("Visibility"));
        Assert.assertEquals(msg.getCssValue("Visibility"), "visible");
    }

    private void clickOnDeleteBtn() {
        WebElement deletebtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deletebtn.click();
    }

    private void clickOnPlaylist() {
        WebElement firstplaylist = driver.findElement(By.xpath(xpathplaylist.replace(" ",playlistname)));
        System.out.println(firstplaylist);
        firstplaylist.click();
    }
    public void createPlaylist() {
        WebElement playlistbtn = driver.findElement(By.cssSelector("i[title='Create a new playlist']"));
        playlistbtn.click();
        WebElement playlistcontextmenu = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        playlistcontextmenu.click();
        WebElement inputplaylistname = driver.findElement(By.cssSelector("input[name='name']"));
        inputplaylistname.sendKeys(playlistname);
        inputplaylistname.sendKeys(Keys.ENTER);
    }

 */
}
