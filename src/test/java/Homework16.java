import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public static void registrationNavigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        String url1 = "https://bbb.testpro.io/registration.php";
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[id = 'hel']"));
                registrationLink.click();
        Assert.assertNotEquals(driver.getCurrentUrl(), url);
        Assert.assertEquals(driver.getCurrentUrl(), url1);
        driver.quit();
    }



}
