import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("taqimed99@gmail.com");
        //driver.wait(5000);
        WebElement passwordField =  driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("Med-20115-010499@");
        //driver.wait(5000);
        WebElement submitButton =  driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        //driver.wait(5000);
        //Assert.assertTrue(usersAvatar.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();
    }
}
