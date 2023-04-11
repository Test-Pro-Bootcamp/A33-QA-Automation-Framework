package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllSongsPage;
import pages.HomePage;

public class PlaylistStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @When("I create a playlist")
    public void iCreateAPlaylist() throws InterruptedException {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        homePage.createPlaylist();
        Thread.sleep(500);
    }

    @Then("New playlist name is on the left menu")
    public void newPlaylistNameIsOnTheLeftMenu() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.playlistCreatedMsg());
    }

    @And("I delete the playlist")
    public void iDeleteThePlaylist() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        homePage.deletePlaylist();
    }

    @Then("The playlist is deleted from the left menu")
    public void thePlaylistIsDeletedFromTheLeftMenu() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.confirmNotification());
    }

    @And("I rename the playlist")
    public void iRenameThePlaylist() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        AllSongsPage allSongPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        homePage.changePlaylistName();
    }

    @Then("The playlist name is changed")
    public void thePlaylistNameIsChanged() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        AllSongsPage allSongPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.confirmNotification());
    }

    @And("I add a song to the playlist")
    public void iAddASongToThePlaylist() throws InterruptedException {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        AllSongsPage allSongPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongPage.addSongsToPlaylist();
    }

    @Then("The song is on the playlist")
    public void theSongIsOnThePlaylist() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        AllSongsPage allSongPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongPage.confirmSongIsAdded();
    }

    @And("I add a song to the playlist by using drag and drop")
    public void iAddASongToThePlaylistByUsingDragAndDrop() throws InterruptedException {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        AllSongsPage allSongPage = new AllSongsPage(BaseDefinition.getThreadLocal());
        allSongPage.dropToAddSong();
    }
}