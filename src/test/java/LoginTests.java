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
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public static void LoginSuccessTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("aaronalbusiness@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitLogin =driver.findElement(By.cssSelector("#app  > div >form > button"));
        //WebElement submitLogin =driver.findElement(By.cssSelector("[type = 'submit']"));
        submitLogin.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }

    @Test
    public static void LoginNotExistingEmailTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("aaronalbusiness@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitLogin =driver.findElement(By.cssSelector("#app  > div >form > button"));
        //WebElement submitLogin =driver.findElement(By.cssSelector("[type = 'submit']"));
        submitLogin.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }

    @Test
    public static void LoginNotEmptyPasswordTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("aaronalbusiness@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitLogin =driver.findElement(By.cssSelector("#app  > div >form > button"));
        //WebElement submitLogin =driver.findElement(By.cssSelector("[type = 'submit']"));
        submitLogin.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }



}
