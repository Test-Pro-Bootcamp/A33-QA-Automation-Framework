import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
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
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }
    public void navigation(){
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public void loginEmail () {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("sinushkinaolesia@gmail.com");
    }
    public void loginPassword () {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }
    public void submit () {
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
        String urlHome = "https://bbb.testpro.io/#!/home";
        driver.get(urlHome);
    }
    public void search () {
        WebElement searchField = driver.findElement(By.cssSelector("[type = 'search']"));
        searchField.click();
        searchField.sendKeys("Pluto");
        WebElement viewAll = driver.findElement(By.cssSelector("div.results section.songs button.view-all-songs-button"));
        viewAll.click();
        WebElement firstSong = driver.findElement(By.cssSelector("div.results section.songs article.tabindex='0'"));
    }


}
