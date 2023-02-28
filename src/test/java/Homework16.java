import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void RegistrationNavigation () {

        WebDriver Driver = new ChromeDriver();
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        Driver.get (url);

        WebElement RegistrationLink = Driver.findElement(By.cssSelector("[id='hel']"));
        RegistrationLink.click();

        String RegistrationUrl = "https://bbb.testpro.io/registration.php";

        Assert.assertEquals (Driver.getCurrentUrl(), RegistrationUrl);
        Driver.quit();
    }
}
