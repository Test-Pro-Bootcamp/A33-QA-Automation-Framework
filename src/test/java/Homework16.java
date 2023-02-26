import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class Homework16 extends BaseTest {
    @Test
    public static void registrationNavigation(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5
        ));

        String url= "https://bbb.testpro.io/";

        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector ("[id='hel']"));
        registrationLink.click();

        String urlRegistration = "https://bbb.testpro.io/Registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),urlRegistration);
        driver.quit();
    }


   }

