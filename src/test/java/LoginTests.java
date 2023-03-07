package src.test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPasswordTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.quit();
    }

    @Test
    public void loginInvalidEmailTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        //Step2. Enter Not Existing email
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("cucaracha@class.com");

        //Step3. Enter Correct password
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("ayCaramba");

        //Step4. Click Login button
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

        //Expected result: User should stay on login page
        // assert the present of email field
        WebElement emailFieldAfterLogin = driver.findElement(By.cssSelector("[type='email']"));
        Assert.assertTrue(emailFieldAfterLogin.isDisplayed());

        driver.quit();
    }

    @Test
    public void loginValidEmailPasswordTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        //Step3. Enter Correct password
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        //Step4. Click Login button
        WebElement loginField = driver.findElement(By.cssSelector("[type='submit']"));
        loginField.click();

        //Expected result: User should be directed to the home page
        WebElement avatar = driver.findElement(By.className("avatar"));
        Assert.assertTrue(avatar.isDisplayed());

        driver.quit();
    }
}
