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

        String urlKoel = "https://bbb.testpro.io/";
        driver.get(urlKoel);

        //Locate web element for the registration link by CSS selector
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        //Click registration link
        registrationLink.click();
        //This is for registration page
        String registrationPage = "https://bbb.testpro.io/registration.php";

        Assert.assertEquals(driver.getCurrentUrl(), registrationPage);
        driver.quit();


    }
}