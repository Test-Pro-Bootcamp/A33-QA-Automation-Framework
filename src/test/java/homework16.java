import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class homework16 extends BaseTest {
    @Test
    public static void registrationNavigation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        //access the registration url

        WebElement registrationLink = driver.findElement(By.cssSelector("[@id='hel']"));
        registrationLink.click();
        Thread.sleep(5000);
        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
        //Im not sure what Im doing wrong here? and I cannot access other projects.
        //I had to rebuild this after I lost it trying to move it as you asked.

    }
}
