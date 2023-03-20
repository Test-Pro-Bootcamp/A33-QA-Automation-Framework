import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public class Homework17 {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Object songTitleKeyword;
        String darkDays = "DarkDays";
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }

    private void searchSong(Object songTitleKeyword) {
    }

    private Collection<Object> getNotificationText() {
        return null;
    }

    private void choosePlaylist() {
    }

    private void clickAddToBtn() {
    }

    private void selectFirstSongResult() {
    }

    private void clickViewAllBtn() {
    }

    private void clickSubmit() {
    }

    private void providePassword(String te$t$tudent) {
    }

    private void provideEmail(String s) {
    }

    private void navigateToPage() {
    }

}
