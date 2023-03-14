import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {

        openLoginURL();
        String url = "https://bbb.testpro.io/";

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}





