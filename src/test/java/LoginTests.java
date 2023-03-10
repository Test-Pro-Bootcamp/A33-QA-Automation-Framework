import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys("regniermandy@gmail.com");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        //Assert.assertTrue();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public static void LoginSuccessTest() {
    //GIVEN Pre-condition: Chrome should be opened
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        //Locate web element for the email field by css selector
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys("regniermandy@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement usersAvatar = driver.findElement(By.xpath(("[alt='Avatar of student']")));
        Assert.assertTrue(usersAvatar.isDisplayed());
        driver.quit();
    }
}
