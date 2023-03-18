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
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected WebDriver driver;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public void contextClick(By locator){
        WebElement clickElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(clickElement).perform();
    }
    protected static WebElement findElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return element;
    }
    protected static void clickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        actions.click(element).perform();
    }
    protected static void doubleClickElement (By elementLocator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        actions.doubleClick(element).perform();
    }
}
