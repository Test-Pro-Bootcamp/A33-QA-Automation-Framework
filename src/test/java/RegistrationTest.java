import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Test
    public static void registrationNavigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // go to url
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        // find the registration link
        WebElement registrationlink = driver.findElement(By.linkText("Registration"));
        registrationlink.click();

        //verify the page title of the registration page
        String expectedTitle = "Koel Registration page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        // close browser
        driver.quit();
    }
}