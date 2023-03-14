
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;

    @BeforeSuite
    public static void setupClass() {
          WebDriverManager.chromedriver().setup();

    }
    private void login() throws InterruptedException {
        provideEmail("guadalupe.medina@testpro.io");
        providePassword("DoingitBig23!");
        submitButton();
    }
    public WebElement getDeletedPlaylistMsg(){
        return driver.findElement(By.cssSelector("div.success.show"));
    }
     public void openPlaylist() throws InterruptedException {
         WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
         emptyPlaylist.click();
         Thread.sleep(2000);
     }

    private void deletePlaylist() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        Thread.sleep(2000);
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);


    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type ='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public static void providePassword(String password) {
        WebElement providePassword = driver.findElement(By.cssSelector("[type='password']"));
        providePassword.clear();
        providePassword.sendKeys(password);
    }

    public static void submitButton() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("Button[type ='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }

    @DataProvider(name = "IncorrectLoginProviders")
    public Object[][] getDataProviders() {
        return new Object[][]{
                {"invalid@email.com", "invalidPassword"},
                {"onlyEmail@email.com",},
                {""}, {""}
        };


    }

}




