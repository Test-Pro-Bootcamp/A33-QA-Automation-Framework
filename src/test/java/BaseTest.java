import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    public static void closeBrowser(){
        driver.quit();
    }

    @Test
    public static void navigateToPage() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Thread.sleep(1000);
    }
    public static void provideEmail(String email) {
        WebElement emailField =driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);


    }

}