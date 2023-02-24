import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Registration extends BaseTest {
    @Test
    public static void GoingToRegistrationPage() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        String urlRegistration = "https://bbb.testpro.io/registration.php";
        driver.get(url);
// Locate web element for registration button using the CSS selector:
        WebElement registrationField = driver.findElement(By.cssSelector("[id='hel']"));
//Click on the registration button
        registrationField.click();

        Thread.sleep(5000);

        Assert.assertNotEquals(driver.getCurrentUrl(), urlRegistration);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }
}

