package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

public BasePage(WebDriver givenDriver){
    driver = givenDriver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    PageFactory.initElements(driver, this);
}

}
