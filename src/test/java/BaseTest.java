import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    WebDriver driver = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://bbb.testpro.io/");
    }


    public void playSong() throws InterruptedException {
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();

    }
    public void logIn(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();

    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

