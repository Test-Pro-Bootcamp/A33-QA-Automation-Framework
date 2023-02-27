import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Homework16  extends BaseTest{
    @Test
    public void Navigation() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();
    }

}
