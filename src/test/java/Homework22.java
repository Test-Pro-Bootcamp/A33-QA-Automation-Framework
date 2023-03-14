
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import java.util.Arrays;
import java.util.List;

public class Homework22 extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    AllSongsPage allSongPage = new AllSongsPage(driver);
    @Test
    public void createPlaylistAndAddSong() {
        //<--login-->
        setupClass();
        loginPage.loginPageTest();


        //<--create playlist/add song/delete playlist-->
        homePage.createPlaylist();
        allSongPage.addSong();
        homePage.deletePlaylist();


    }
}








