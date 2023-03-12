import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import static org.openqa.selenium.By.cssSelector;

public class BasePage {
    public static WebDriver driver = null;
    public static WebDriverWait wait;
    public static String url = null;
    Actions actions;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }
    public void contextClick(By locator){
        WebElement clickElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(clickElement).perform();
    }
}
