import org.junit.Test;

public class Homework17 {

    @Test
    public void addSongToPlaylist() {
        // Navigate to the website
        WebDriver driver = new ChromeDriver();
        driver.get("https://bbb.testpro.io/");

        // Log in with your credentials
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));

        emailField.sendKeys("your_email_here");
        passwordField.sendKeys("your_password_here");
        loginButton.click();

        // Search for a song
        WebElement searchField = driver.findElement(By.name("searchTerm"));
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));

        searchField.sendKeys("song_name_here");
        searchButton.click();

        // Click View All to display the search results
        WebElement viewAllButton = driver.findElement(By.xpath("//button[contains(text(),'View All')]"));
        viewAllButton.click();

        // Click the first song in the search results
        WebElement firstSong = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a"));
        firstSong.click();

        // Click ADD TO...
        WebElement addToButton = driver.findElement(By.xpath("//button[contains(text(),'Add to')]"));
        addToButton.click();

        // Choose the playlist to add it to
        WebElement playlistField = driver.findElement(By.name("playlistName"));
        WebElement createPlaylistButton = driver.findElement(By.xpath("//button[contains(text(),'Create Playlist')]"));

        playlistField.sendKeys("unique_playlist_name_here");
        createPlaylistButton.click();

        // Verify that the notification message appears and has the correct text
        WebElement notificationMessage = driver.findElement(By.className("notification-message"));
        String expectedMessage = "Added 1 song into unique_playlist_name_here";
        String actualMessage = notificationMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

        // Close the browser
        driver.quit();
    }