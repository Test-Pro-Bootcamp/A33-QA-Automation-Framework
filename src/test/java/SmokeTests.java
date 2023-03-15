import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SmokeTests extends BaseTest{

    public String url = "https://bbb.testpro.io/";
    LoginPage loginpage = new LoginPage(driver);
    AllSongsPage allsongspage = new AllSongsPage(driver);
    HomePage homepage = new HomePage(driver);
    @Test
    public void renamePlaylist(){
        loginpage.login();
        homepage.doubleClickOnPlaylist()
        .typeNewName();
        //.successMessage();
    }
    @Test
    public void addSongToFavorites(){
        By iconlocator = By.cssSelector("button[data-test='like-btn']");
        loginpage.login();
        WebElement hearticon = wait.until(ExpectedConditions.elementToBeClickable(iconlocator));
        hearticon.click();
        String favoritebtntitle = hearticon.getAttribute("title");
        System.out.println(favoritebtntitle);
        Assert.assertTrue(favoritebtntitle.contains("Unlike"));
    }
    @Test
    public void deletePlaylist() {
        driver.get("https://bbb.testpro.io/#!/home");
        loginpage.login();
        homepage.createPlaylist()
                .clickOnPlaylist()
                .clickOnDeleteBtn();
        WebElement msg = driver.findElement(By.cssSelector("div[class='success show']"));
        System.out.println(msg.getCssValue("Visibility"));
        Assert.assertEquals(msg.getCssValue("Visibility"), "visible");
    }
    @Test
    public void addSongToPlaylist() {
        loginpage.login();
        allsongspage.createPlaylist()
                .clickAllSongs()
                .addFirstSongToPlaylist();
        Assert.assertTrue(msgPopup());
    }
    public boolean msgPopup() {
        WebElement msg = driver.findElement(By.cssSelector("div[class='success show']"));
        return (msg.isDisplayed());
    }

        @Test(enabled = false)
        public void registrationNavigation() {
        WebElement registrationbtn = driver.findElement(By.id("hel"));
        registrationbtn.click();
        Assert.assertEquals(driver.getTitle(),"Koel Registration page");
        driver.quit();
    }
        @Test
        public void playSong(){
            loginpage.login();
            WebElement covericon = driver.findElement(By.cssSelector("article span.cover"));
            covericon.click();
            Assert.assertTrue(soundBarIsDisplayed());

        }
        @Test
        public void clickPlayBtn() {
            loginpage.login();
            WebElement covericon = driver.findElement(By.cssSelector("article span.cover"));
            covericon.click();
            Actions action= new Actions(driver);
            WebElement playbtn = driver.findElement(By.cssSelector("footer div span[role='button']"));
            action.moveToElement(playbtn).perform();
            WebElement nextbtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
            action.moveToElement(nextbtn).click().build().perform();
            soundBarIsDisplayed();
            pauseBtnIsDisplayed();

        }
        public boolean soundBarIsDisplayed(){
            WebElement soundbar = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
            return(soundbar.isDisplayed());
        }
        public boolean pauseBtnIsDisplayed(){
            WebElement pausebtn = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
            return(pausebtn.isDisplayed());
        }
}