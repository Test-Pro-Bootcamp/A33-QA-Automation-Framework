package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
WebDriver driver;
WebDriverWait wait;
Actions action;

public BasePage(WebDriver givenDriver){
    driver = givenDriver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}

}
