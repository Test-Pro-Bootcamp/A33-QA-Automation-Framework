import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSongTest() throws InterruptedException {
        navigateToPage();
        provideEmail("krista_ua86@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //Creating object of an Actions class
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        //Performing the mouse hover action on the target element.
        action.moveToElement(playBtn).perform();
        playBtn.click();
        Thread.sleep(4000);

        WebElement pauseBtn =driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
    }
}


