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
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    static void setupClass() { WebDriverManager.chromedriver().setup(); }

    @BeforeMethod
    public void setUpBrowser () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public static void openLoginURL() {
        driver.get("https://bbb.testpro.io");
        driver.get(url);
    }

    public void provideEmail (String email) {
        WebElement emailField = driver.findElement (By.cssSelector("[Type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword (String password) {
        WebElement passwordField = driver.findElement (By.cssSelector("[Type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement emailElement = driver.findElement(By.cssSelector("button[Type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }

    }
