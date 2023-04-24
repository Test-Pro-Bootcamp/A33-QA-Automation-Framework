import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

    WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    public void logIn(String email, String password) {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys(password);
        WebElement submit = driver.findElement(By.cssSelector("[type = 'submit']"));
        submit.click();
    }

    public void playSong() {
        WebElement playNext = driver.findElement(By.cssSelector("[data-testid = 'play-next-btn']"));
        playNext.click();
        WebElement play = driver.findElement(By.cssSelector("[data-testid = 'play-btn']"));
        play.click();

        }
    }

