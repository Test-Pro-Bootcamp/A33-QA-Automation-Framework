import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        String url2 = "https://bbb.testpro.io/registration.php";

        driver.get(url);
        driver.findElement(By.xpath("//form/a")).click();

        Assert.assertEquals(driver.getCurrentUrl(), url2);
        driver.quit();
        }

    }

