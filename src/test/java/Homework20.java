import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import java.time.Duration;
public class Homework20 extends BaseTest {
    @Test
    public void seleniunWaitsHomework() {

    logIn("regniermandy@gmail.com", "te$t$tudent");
    playSong();

    }
}
