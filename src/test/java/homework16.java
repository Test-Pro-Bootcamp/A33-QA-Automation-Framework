import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public  void registrationNavigation() {
       String webdrvier = new ChromeDriver();
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Im not sure what Im doing wrong here? and I cannot access other projects.
        //I had to rebuild this after I lost it trying to move it as you asked.

    }
}
