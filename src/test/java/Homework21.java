public class Homework21 extends LoginTests{


    import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

    public class Homework20 extends LoginTests {

    }
//Prerequisite - at least one user created playlist

        String newPlaylistName = "Sample Edited Playlist";

        @Test
        public void renamePlaylist() {

            String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

            provideEmail ("demo@class.com");
            providePassword ("te$t$tudent");
            clickSubmit ();
            doubleClickPlaylist ();
            enterNewPlaylistName ();
            Assert.assertEquals (getRenamePlaylistSuccessMsg (), updatedPlaylistMsg);
        }

        public void doubleClickPlaylist() {
            WebElement playlistElement = wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".playlist:nth-child(3)")));
            actions.doubleClick (playlistElement).perform ();
        }

        public void enterNewPlaylistName() {
            WebElement playlistInputField = wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("[name='name']")));
//   clear() does not work, element has an attribute of "required"
//   workaround is crtl A(to select all) then backspace to clear then replace with new playlist name
            playlistInputField.sendKeys (newPlaylistName);
            playlistInputField.sendKeys (Keys.ENTER);
        }

        public String getNewPlaylistName() {
            WebElement notification = wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("div.success.show")));
            return notification.getText ();

        }
    }

