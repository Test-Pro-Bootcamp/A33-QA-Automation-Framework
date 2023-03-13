package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    String password = "";
    String email = "";

    String koelStart = "https://bbb.testpro.io/#!/login";

    String koelHome = "https://bbb.testpro.io/#!/home";
    String koelSongs = "https://bbb.testpro.io/#!/songs";
    String koelRecentlyPlayed = "https://bbb.testpro.io/#!/recently-played";
    String koelRegi = "https://bbb.testpro.io/registration.php";

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);

    }

    public void setLogEmail(String mail, String pass) {
        password = pass;
        email = mail;
    }

    public void doubleClickElement(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable((locator)));
        actions.doubleClick(locator).perform();
    }
}
