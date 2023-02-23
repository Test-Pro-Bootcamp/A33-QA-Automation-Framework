import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework extends BaseTest {


    @Test
    public static void registrationNavigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        String urlRegistration = "https://bbb.testpro.io/Registration.php";
        driver.get(url);


        WebElement registrationButton = driver.findElement(By.xpath("//a[@type='submit']"));
        registrationButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);
        driver.quit();

    }

}
