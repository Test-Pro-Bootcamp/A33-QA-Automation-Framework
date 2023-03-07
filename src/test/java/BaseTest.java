import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
     WebDriver driver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void openBrowser(){
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public void closeBrowser(){
        driver.quit();
    }
    public void enterEmail(){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("ayoub.rafiqui@testpro.io");
    }

    public void enterPassword(){
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("ayoub.rafiqui@testpro.io");
    }
    public void submit(){
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public void searchForSong(){
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Lament");
    }
    public void clickViewAll(){
        WebElement viewAll = driver.findElement(By.cssSelector("[class='panes']"));
        viewAll.click();
    }
    public void clickFirstSong(){
        WebElement firstSong = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div >" +
                " section.songs > ul > article > span.main > span.details"));
        firstSong.click();


    }
    public void clickAddTo(){
        WebElement addToBtn = driver.findElement(By.cssSelector("[class='has-sub']"));
        addToBtn.click();
    }

    public void choosePlaylist(){
        WebElement chosenPlaylist = driver.findElement(By.cssSelector("#app > nav > ul > li.has-sub > ul > li:nth-child(8)"));
    }
    public String getNotification(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
}
