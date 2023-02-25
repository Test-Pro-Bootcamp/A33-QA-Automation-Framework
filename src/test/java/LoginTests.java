import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    public void openLoginUrl(){
        String url = "https://bbb.testpro.io";
        driver.get(url);
    }
    public void enterEmail(String email){
        WebElement emailfield = driver.findElement(By.cssSelector("input[type='email']"));
        emailfield.sendKeys(email);

    }
    public void enterPassword(String password){
        WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
        passwordfield.sendKeys(password);

    }
    public void submit(){
        WebElement submitbtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitbtn.click();
    }

    @Test
    public void login() {

        openLoginUrl();
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }



}
