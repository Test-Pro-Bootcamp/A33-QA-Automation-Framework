import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public static void RegistrationNavigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        String url2 = "https://bbb.testpro.io/registration.php";
        driver.get(url);
        WebElement RegistrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        RegistrationLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), url2);
        driver.quit();
    }
}