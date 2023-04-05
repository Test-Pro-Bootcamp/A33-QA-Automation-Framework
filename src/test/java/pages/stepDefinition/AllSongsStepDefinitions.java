package pages.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.AllSongsPage;

public class AllSongsStepDefinitions {
    WebDriver driver;
//    @Before
//    public void openBrowser() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }

//    @After
//    public void iCloseTheBrowser() {
//        driver.quit();
//    }
    @Then("Songs are sorted correctly")
    public void songsAreSortedCorrectly() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.sortSongs();
    }

    @And("I click the song title column")
    public void iClickTheSongTitleColumn() {
    AllSongsPage allSongsPage = new AllSongsPage(driver);
    allSongsPage.clickSongTitleColumn();
    }
}