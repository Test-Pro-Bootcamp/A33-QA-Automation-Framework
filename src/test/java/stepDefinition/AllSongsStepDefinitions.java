package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.AllSongsPage;

public class AllSongsStepDefinitions {
    WebDriver driver;

    @Then("Songs are sorted correctly")
    public void songsAreSortedCorrectly() {

        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongsPage.sortSongs();
    }

    @And("I click the song title column")
    public void iClickTheSongTitleColumn() {
    AllSongsPage allSongsPage = new AllSongsPage(BaseDefinition.getThreadLocal());
    allSongsPage.clickSongTitleColumn();
    }
}
