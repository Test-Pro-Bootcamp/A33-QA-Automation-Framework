import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public static void registrationNavigation() {
        //GIVEN: Chrome browser should be opened
        WebDriver driver = new ChromeDriver();
        //wait 10 seconds for an element to load before failing a test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //open a URL
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        //locate web element for email field by css selector
        WebElement registration = driver.findElement(By.cssSelector("[id='hel']"));
        //click to element
        registration.click();
        //driver.wait(5000);
        String registrationPage = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationPage);
        driver.quit();


    }
}
