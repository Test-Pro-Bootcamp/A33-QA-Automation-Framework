
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

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {

//       Chromeoptions argument fixes the error below:
//        Fixes the error below:
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

    public static void navigateToPage() {
        String url = "BaseURL";
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

    @DataProvider(name = "IncorrectLoginPoviders")
    public static Object[][] getDataProviders() {
        return new Object[][]{
                {"invalid@email.com", "invalidPassword"},
                {"onlyEmail@email.com",},
                {""}, {""}
        };


    }

}




