import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
public class HomeWork16 extends BaseTest {

    @Test
    public static void registrationNavigation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io";
        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement registrationUrl = driver.findElement(By.cssSelector("#hel"));
        registrationUrl.click();
//        driver.wait(5000);
        String registrationLink = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationLink);
        driver.quit();
    }
}

