import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void AddSongToPlaylist() throws InterruptedException {

        enterEmail("linulya1411@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        searchForSong("Beautiful");
        viewAllResults();
        selectFirstSong();
        clickAddTo();






        //Verify we are still in log in page
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://apps.testpro.io/");
    }

    private void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email'"));
        emailField.click();
        emailField.sendKeys(email);
    }

    private void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password'"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    private void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit'"));
        submitButton.click();
    }

    private void searchForSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("#searchForm"));
        searchField.sendKeys();
        Thread.sleep(2000);
    }
    private void viewAllResults() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("selection#searchExcerptsWrapper section h1 button"));
        viewAllButton.click();
        Thread.sleep(2000);
    }
    private void selectFirstSong() throws InterruptedException {
        WebElement selectFirstFromTheList = driver.findElement(By.cssSelector("selection#songResultsWrapper tr.song-item td.title"));
        selectFirstFromTheList.click();
        Thread.sleep(2000);
    }
    private void clickAddTo() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("[class='button.btn-add-to']"));
        addToButton.click();
        Thread.sleep(2000);
    }

}
