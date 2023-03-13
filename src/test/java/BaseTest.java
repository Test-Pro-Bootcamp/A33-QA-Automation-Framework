import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver= null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void launchBrowser() {
//       Chromeoptions argument fixes the error below:
        //WARNING: Invalid Status code=403 text=Forbidden
        //java.io.IOException: Invalid Status code=403 text=Forbidden
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }

    protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type ='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void passwordField(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void submitButton() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("Button[type ='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
}