import java.time.Duration;

public class Homework19 extends BaseTest {

    @BeforeMethods
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--remote-allow-origins");

        driver = new ChromeDriver (options);
        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
        url = BaseURL;
        navigateToPage ();
    }


    public void navigateToPage() {
        driver.get (url);

    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement (By.cssSelector ("input[type='email']"));
        emailField.clear ();
        emailField.sendKeys (email);
    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement (By.cssSelector ("input[type='password']"));
        passwordField.clear ();
        passwordField.sendKeys (password);
    }
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"TestPro Playlist.\"";
        provideEmail ("demo@class.com");
        providePassword ("te$t$tudent");
        clickSubmit ();
        openPlaylist ();
        clickDeletePlaylistBtn ();
        Assert.assertEquals (getDeletePlaylistMsg (), expectedPlaylistDeletedMessage);
    }
    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement (By.cssSelector (".playlist:nth-child(3)"));
        emptyPlaylist.click ();
    }
    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement (By.cssSelector (".btn-delete-playlist"));
        deletePlaylist.click ();
        Thread.sleep (2000);
    }
    public String getDeletePlaylistMsg() {
        WebElement notificationMsg = driver.findElement (By.cssSelector ("div.success.show"));
        return notificationMsg.getText ();
    }
}