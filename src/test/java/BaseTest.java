import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {
    WebDriver driver = new ChromeDriver();
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void playSong() throws InterruptedException {
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        Thread.sleep(5000);
        playButton.click();
    }
    protected void logIn(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("[type = submit']"));
        submitButton.click();

    }
}

