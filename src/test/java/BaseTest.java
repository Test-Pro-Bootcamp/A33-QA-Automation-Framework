import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    static WebDriver driver;


    @BeforeMethod

    public void setUpBrowser() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver",
                "/Users/macbook/Documents/A33-QA-Automation-Framework/build/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
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
