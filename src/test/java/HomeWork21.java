import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


package src.test.java;

public class HomeWork21 {

    // Create an instance of the WebDriver
    WebDriver driver = new ChromeDriver();

// Navigate to the page containing the playlist
driver.get("http://www.example.com/playlists");

    // Identify the playlist to rename
    WebElement playlist = driver.findElement(By.xpath("//div[contains(@class, 'playlist') and h2[contains(text(), 'My Playlist')]]"));


    // Click on the "Rename" option in the context menu
    WebElement renameOption = driver.findElement(By.xpath("//ul[contains(@class, 'context-menu')]/li[contains(text(), 'Rename')]"));
renameOption.click();

    // Wait for the modal dialog to appear
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement modalDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rename-dialog")));

    // Enter the new playlist name in the input field
    WebElement nameField = modalDialog.findElement(By.id("name-field"));
nameField.clear();
nameField.sendKeys("My New Playlist Name");

    // Click on the "Save" button
    WebElement saveButton = modalDialog.findElement(By.id("save-button"));
saveButton.click();

}