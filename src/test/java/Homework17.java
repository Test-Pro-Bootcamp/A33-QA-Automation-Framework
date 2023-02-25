import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends LoginTests {

    @Test
    public static void addSongToPlaylist() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        String urlLogin = "https://bbb.testpro.io/";
        String urlRegi = "https://bbb.testpro.io/registration.php";
        driver.get(urlLogin);

        //css selector setup
        WebElement registrationButton = driver.findElement(By.cssSelector("a[id='hel']"));

        //click on thing
        registrationButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), urlRegi);
        driver.quit();
    }
}
