import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {

    public String url = "https://bbb.testpro.io/";


    @Test
    public void registrationNavigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        WebElement registrationbtn = driver.findElement(By.id("hel"));
        registrationbtn.click();
        Assert.assertEquals(driver.getTitle(),"Koel Registration page");
        driver.quit();
    }
}