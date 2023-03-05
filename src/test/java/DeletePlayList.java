import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DeletePlayList extends BaseTest {

    @Test
    public static void addSongToPlaylist() throws InterruptedException {
        navigateToPage("https://bbb.testpro.io/");

        // Login to the Homepage Koel
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");
        clickSubmit();
        Thread.sleep(2000);

        selectPlaylisttoDelete();
        removePlaylist();
        cancel();

    }
}
