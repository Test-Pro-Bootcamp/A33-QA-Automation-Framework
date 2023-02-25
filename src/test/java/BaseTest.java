import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {
    WebDriver driver = new ChromeDriver();
    String koelStart = "https://bbb.testpro.io/";
    String koelHome = "https://bbb.testpro.io/#!/home";
    WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
    WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
    WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupBrowser() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @AfterMethod
    public void exitBrowser() {
        driver.quit();
    }

}
