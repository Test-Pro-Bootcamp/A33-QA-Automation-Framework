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

        String url = "https://bbb.testpro.io/";
        String urlRegistration = "https://bbb.testpro.io/Registration.php";
        driver.get(url);
        Thread.sleep(5000);


        WebElement registrationButton = driver.findElement(By.xpath("//a[@type='submit']"));
        registrationButton.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);
        driver.quit();

    }

}
