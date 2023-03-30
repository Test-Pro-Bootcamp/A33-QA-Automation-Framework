package Pages;

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
    protected Actions actions;
    protected static WebDriver driver;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void contextClick(By locator) {
        WebElement clickElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(clickElement).perform();
    }
}




