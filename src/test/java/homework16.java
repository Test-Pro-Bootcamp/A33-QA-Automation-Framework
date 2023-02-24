import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework16 extends BaseTest {
@Test
    public void registrationNavigation(){
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       String URL =  "https://bbb.testpro.io/";
       String RegistrationURL = "https://bbb.testpro.io/registration.php";
       driver.get(URL);
       WebElement registrationButton = driver.findElement(By.cssSelector("a[href='/registration.php']"));
       registrationButton.click();

    Assert.assertEquals(driver.getCurrentUrl(), RegistrationURL);
    driver.quit();



    }




}
