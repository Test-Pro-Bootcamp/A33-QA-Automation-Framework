package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected  static Actions action;
    private static final int time = 6; //time in seconds for timeout wait

    public BasePage (WebDriver submittedDriver) {
        driver = submittedDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        action = new Actions(driver);
    }

    public static void navigateToPage(String url) {
        driver.get(url);
    }

    protected static WebElement findElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return element;
    }
    protected static void clickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        action.click(element).perform();
    }
    protected static void doubleClickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        action.doubleClick(element).perform();
    }
    protected static void contextClickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        action.contextClick(element).perform();
    }
}
