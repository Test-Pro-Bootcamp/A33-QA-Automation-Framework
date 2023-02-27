import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddSongToPlaylist extends BaseTest {

    @Test
    public static <Actions> void AddSongToPlaylistTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        String urlHome = "https://bbb.testpro.io/#!/home";

        driver.get(url);
        //These are the elements that we need to access the CSS selector:

        WebElement loginField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[placeholder='Password']"));
        WebElement submitLogin = driver.findElement(By.cssSelector("[type='submit']"));

        //WHEN user types in their email address

        loginField.sendKeys("janezelenova@gmail.com");
        passwordField.click();
        passwordField.sendKeys("Floridaliving2023$");
        submitLogin.click();

        Thread.sleep(5000);

        driver.get(urlHome);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);


        WebElement from = driver.findElement(By.cssSelector("[class=details]"));
        WebElement to = driver.findElement(By.cssSelector("[href=#!/playlist/33391]"));

        //now drag and drop

        Actions builder = new Actions(driver);

        builder.dragAndDrop(from, to).perform();

        Thread.sleep(5000);


        Assert.assertEquals(driver.getCurrentUrl(), urlHome);
        Assert.assertNotEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
