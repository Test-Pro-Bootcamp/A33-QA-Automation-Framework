package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchPage;

public class SearchStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    String query = "dark";
    @When("I type a search keyword {string}")
    public void iTypeASearchKeyword(String query) throws InterruptedException {
        SearchPage searchPage = new SearchPage(BaseDefinition.getThreadLocal());
        searchPage.typeSearchQuery(query);
    }

    @Then("I can find an artist")
    public void iCanFindAnArtist() {
        SearchPage searchPage = new SearchPage(BaseDefinition.getThreadLocal());
        searchPage.artistIsDisplayed();
    }

    @Then("I can find a song")
    public void iCanFindASong() {
        SearchPage searchPage = new SearchPage(BaseDefinition.getThreadLocal());
        searchPage.songIsDisplayed();
    }

    @Then("I can find an album")
    public void iCanFindAnAlbum() {
        SearchPage searchPage = new SearchPage(BaseDefinition.getThreadLocal());
        searchPage.albumIsDisplayed();
    }
}
