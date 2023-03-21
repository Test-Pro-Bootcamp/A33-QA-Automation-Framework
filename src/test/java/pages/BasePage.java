package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected  static Actions action;
    private static final int TIME = 7; //time in seconds for timeout wait

    public BasePage (WebDriver submittedDriver) {
        driver = submittedDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME));
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

//    protected WebElement findElement (By elementLocator) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
//    }

    protected void clickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        action.click(element).perform();
    }
    protected void doubleClickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        action.doubleClick(element).perform();
    }
    protected static void contextClickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        action.contextClick(element).perform();
    }
}
