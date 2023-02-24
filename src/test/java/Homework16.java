import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;


public class Homework16 extends BaseTest {

    @Test
    public static void registrationNavigation() throws InterruptedException {



    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String url = "https://bbb.testpro.io";
    String registrationUrl = "https://bbb.testpro.io/registration.php";
    driver.get(url);

    WebElement registrationButton = driver.findElement(By.xpath("//*[@id=\"hel\"]"));
    registrationButton.click();
    Thread.sleep(5000);

    Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
    driver.quit();
    }
}
