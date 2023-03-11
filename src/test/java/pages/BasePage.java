package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;


public class BasePage {

    protected static WebDriver driver;
    private WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        actions = new Actions(driver);
    }

    //public static WebDriver driver = null;


    //public static String url = null;

    //String playlistName = ":)";

    // public BasePage(WebDriver givenDriver) {
    // driver = givenDriver;
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    // Actions actions = new Actions(driver);
    // }


    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }
}
