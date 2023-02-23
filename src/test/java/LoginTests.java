import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    /*
    WebElement emailfield = driver.findElement(By.cssSelector("input[type='email']"));
    WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
    WebElement submitbtn = driver.findElement(By.cssSelector("button[type='submit']"));
    public void enterEmail(String email){
        emailfield.sendKeys(email);
        return;
    }
    public void enterPassword(String password){
        passwordfield.sendKeys(password);
        return;
    }
    public void submit(){
        submitbtn.click();
    }*/
    @Test
    public void login() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io";
        driver.get(url);
        WebElement emailfield = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement submitbtn = driver.findElement(By.cssSelector("button[type='submit']"));
        emailfield.sendKeys("maxim.ibon@gmail.com");
        passwordfield.sendKeys("te$t$tudent1");
        submitbtn.click();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }



}
