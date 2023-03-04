package src.test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework19 {

    private WebDriver driver;

    @BeforeTest
    @Parameters("baseUrl")
    public void setup(String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        // Login with your credentials
        login("username", "password");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void deletePlaylist() {
        // Click on the playlist you want to delete
        clickPlaylist("playlist name");
        // Click on the delete button
        clickDeleteButton();
        // Verify that the confirmation notification is displayed
        verifyConfirmationMessage("Deleted playlist playlist name");
    }

    private void login(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    private void clickPlaylist(String playlistName) {
        WebElement playlist = driver.findElement(By.xpath("//div[@class='playlist-item'][contains(text(), '" + playlistName + "')]"));
        playlist.click();
    }

    private void clickDeleteButton() {
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(), 'x PLAYLIST')]"));
        deleteButton.click();
    }

    private void verifyConfirmationMessage(String message) {
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(), '" + message + "')]"));
        assert confirmationMessage.isDisplayed();
    }
}
