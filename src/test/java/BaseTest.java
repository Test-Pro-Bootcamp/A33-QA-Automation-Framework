import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {
    public WebDriver driver;
    WebDriverWait wait;



    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        String url = "https://bbb.testpro.io";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



//delete after

    public void openLoginUrl() {
        String url = "https://bbb.testpro.io";
        driver.get(url);
    }
    public void enterEmail(String email) {
        WebElement emailfield = driver.findElement(By.cssSelector("input[type='email']"));
        emailfield.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
        passwordfield.sendKeys(password);
    }

    public void submit() {
        WebElement submitbtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitbtn.click();
    }

    public void login() {
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
    }


}
