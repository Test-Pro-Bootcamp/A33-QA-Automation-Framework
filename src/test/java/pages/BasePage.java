package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected  static Actions action;
    private static final int TIME = 8; //time in seconds for timeout wait

    @FindBy(css = "img.avatar")
    protected WebElement avatarIcon;

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

    public Boolean isAvatarIconDisplayed () {
        return wait.until(ExpectedConditions.visibilityOf(avatarIcon)).isDisplayed();
    }
    protected void clickElement (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    protected void contextClickElement (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.contextClick(element).perform();
    }
}
