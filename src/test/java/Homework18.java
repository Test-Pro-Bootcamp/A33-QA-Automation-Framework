import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong(){
        openLoginUrl();
        login();
        WebElement covericon = driver.findElement(By.cssSelector("article span.cover"));
        covericon.click();
        Assert.assertTrue(soundBarIsDisplayed());

    }
    @Test
    public void clickPlayBtn() {
        openLoginUrl();
        login();
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
