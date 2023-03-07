import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.sql.Driver;
import java.time.Duration;


public class BaseTest {
    WebDriver driver;
  
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseUrl"})
    public void setUpBrowser(String baseUrl){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("baseUrl");
        
    }


    public void logIn(String email, String password){
     WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
     emailField.sendKeys(email);
     WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
     passwordField.sendKeys(password);
     WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));

        
    }

    public WebElement getDeletedPlaylistMsg(){
        return driver.findElement(By.cssSelector("div.success.show"));
        
    }
    public void openPlaylist() throws InterruptedException{
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(2000);
    }
    public void deletedPlaylist() throws InterruptedException{
       WebElement deletedPlaylistButton = driver. findElement(By.cssSelector(".btn-delete-playlist"));
       deletedPlaylistButton.click();
       Thread.sleep(2000);
    }

}
