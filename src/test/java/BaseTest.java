
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg=driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }
    public void openPlaylist() {
        WebElement emptyPlaylist =driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();

    }

    public void clickDeletePlaylistBtn() throws InterruptedException{
        WebElement deletePlaylist= driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }
    @BeforeMethod
    @Parameters("baseUrl")
    public void setUpBrowser(String baseUrl) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public static void closeDownBrowser() {
        driver.quit();
    }

    public void logIn() {
        provideEmail("krista_ua86@gmail.com");
        providePassword("te$t$tudent");
        submit();
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
    }

    public static void submit()  {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }


}
























