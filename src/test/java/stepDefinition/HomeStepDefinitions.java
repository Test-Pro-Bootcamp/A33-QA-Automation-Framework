package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllSongsPage;
import pages.HomePage;

public class HomeStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;



    @And("I choose the song")
    public void iChooseTheSong(){
        HomePage homePage = new HomePage(driver);
        homePage.clickFirstSong();
    }

    @And("I play the song")
    public void iPlayTheSong() throws InterruptedException {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        HomePage homePage = new HomePage(driver);
        allSongsPage.clickAllSongsPage();
        homePage.playSongByClickingBtn();
    }

    @Then("The song play")
    public void verifyTheSongPlay() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.visualizerIsDisplayed());
    }

    @And("I stop the song")
    public void iStopTheSong() {
        HomePage homePage = new HomePage(driver);
        homePage.pauseSongByClickingBtn();
    }

    @Then("The song stops")
    public void verifySongStops() {
        HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.visualizerIsNotDisplayed());
    }

    @And("I open the AllSongs page")
    public void iOpenTheAllSongsPage() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.clickAllSongsPage();
    }
}
