import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;
public class BaseTest {
    // Locators for Login
    By emailFieldLocator = By.cssSelector("[type = 'email']");
    By passwordFieldLocator = By.cssSelector("[type = 'password']");
    By submitButtonLocator = By.cssSelector("[type = 'submit']");
    // Locators for Homework 19: Delete an existing Playlist
    By deletePlaylistBtnLocator = By.cssSelector("button[title='Delete this playlist']");
    By deleteNotifyLocator=By.cssSelector("div.success.show");
    // Locators for Homework 18: Play Song
    By playNextSongButton = By.xpath("//*[@title = 'Play next song' and @data-testid='play-next-btn']");
    By playSongButton = By.xpath("//*[@title='Play or resume' and  @data-testid='play-btn']");
    By pauseButton = By.xpath("//span[@title ='Pause' and @data-testid='pause-btn']");
    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    By progressBarLocator = By.xpath("//progress[@class='plyr__progress--played']");
    // Locators for Homework 17: Add Song to Playlist
    By searchField = By.cssSelector("[type='search']");
    By viewAllButton = By.cssSelector("[data-test ='view-all-songs-btn']");
    By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    By addToButton = By.cssSelector("[data-test = 'add-to-btn']");
    By notification = By.cssSelector("div.success.show");
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        Is same as:
//        options.addArguments("--start-maximized");
        url = baseURL;
        driver.get(baseURL);
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
    public void registrationNavigation() {
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("[id = 'hel']")));
        registrationLink.click();
        System.out.println("Registration link is clicked");
    }
    public void provideEmail(String email) {
    WebElement emailFieldElement = wait.until(ExpectedConditions.elementToBeClickable
                (emailFieldLocator));
    emailFieldElement.clear();
    emailFieldElement.sendKeys(email);
}
    public void providePW(String password) {
        WebElement pwFieldElement = wait.until(ExpectedConditions.elementToBeClickable
                (passwordFieldLocator));
        pwFieldElement.clear();
        pwFieldElement.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement subButtonElement = wait.until(ExpectedConditions.elementToBeClickable
                (submitButtonLocator));
        subButtonElement.click();
    }
    public void login(String email, String password) {
        provideEmail(email);
        providePW(password);
        clickSubmit();
    }
    public static void createNewSimplePlaylist(String Playlist){
        WebElement newPlaylistCircleIcon = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("i[title='Create a new playlist']")));
               // (By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));
        newPlaylistCircleIcon.click();
        WebElement newSimplePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")));
        newSimplePlaylist.click();
        WebElement nameInputField = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//form[@name='create-simple-playlist-form']//input[@type='text']")));
          //      (" input[name='name']")));
        nameInputField.clear();
        nameInputField.sendKeys(Playlist);
        nameInputField.sendKeys(Keys.ENTER);
        System.out.println("Playlist " +Playlist+ " is created");
    }
    public String newPlaylistNotification(){
        WebElement newPlaylistMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='alertify-logs top right']//div[@class='success show']")));
        String MsgText= newPlaylistMsg.getText();
        System.out.println("Msg Notification: " + MsgText);
        return MsgText;
    }
    public boolean newPlaylistIsDisplayed(){
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//li[@class='playlist playlist']//a[@class='active']")));
        boolean isDisplayed = newPlaylist.isDisplayed();
        System.out.println("Playlist is displayed = "+ isDisplayed );
        return isDisplayed;
    }
    // Homework 17: Add Song to Playlist
    public void searchSong (String songText)  {
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchElement.sendKeys(songText);
        System.out.println(songText + " is typed in search field");
    }
    public void clickViewAllButton ()  {
        WebElement viewAllElement = wait.until(ExpectedConditions.elementToBeClickable(viewAllButton));
        viewAllElement.click();
        System.out.println("View All Button is clicked");
    }
    public void clickFirstSong () {
        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(selectSong));
        clickSong.click();
        System.out.println("First Song is clicked");
    }
    public void clickAddToButton () {
        WebElement addToElement = wait.until(ExpectedConditions.elementToBeClickable(addToButton));
        addToElement.click();
        System.out.println("Add-To Button is clicked");
    }
    public void clickPlaylist (String Playlist) {
        String choosePlaylist =
                "//section[@id='songResultsWrapper']//li[contains(text(), '" + Playlist + "')]";
        WebElement choosePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(choosePlaylist)));
        choosePlaylistElement.click();
        System.out.println("Playlist " + Playlist + " is clicked");
    }
    public String getNotification (){
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
        String notifyText= notificationMessage.getText();
        System.out.println("Notification Message is: " + notifyText);
        return notifyText;
    }
    //Homework 18: Play a song
    public void clickPlayNextSong() {
        WebElement playNextSongElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (playNextSongButton));
        playNextSongElement.click();
        System.out.println("Play Next Song Button is clicked");
    }
    public void clickPlaySong() {
        WebElement playSongElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (playSongButton));
        playSongElement.click();
        System.out.println("Play Song Button is clicked");
    //    Actions actions = new Actions(driver);
    //    actions.click(playSongElement).perform();
    }
    public boolean pauseButtonDisplay()  {
        WebElement pauseButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (pauseButton));
        boolean PauseDisplaySuccess = pauseButtonElement.isDisplayed();
        System.out.println("Pause Button Displayed = " + PauseDisplaySuccess);
        return PauseDisplaySuccess;
    }
    public boolean soundBarVisualizerDisplay() {
        WebElement soundBarVisualizerBarElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (soundBarVisualizer));
        boolean soundBarVisualDisplaySuccess = soundBarVisualizerBarElement.isDisplayed();
        System.out.println("SoundBar Visualizer Displayed = " + soundBarVisualDisplaySuccess);
        return soundBarVisualDisplaySuccess;
    }
    public boolean progressBarDisplay(){
        WebElement progressBarElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (progressBarLocator));
        boolean progressBarDisplaySuccess = progressBarElement.isDisplayed();
        System.out.println("ProgressBar Displayed = " + progressBarDisplaySuccess);
        return progressBarDisplaySuccess;
    }
    // Delete Song From Playlist
    public void deleteSongFromPlaylist() {
        WebElement selectSong = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("div[class='song-list-wrap main-scroll-wrap playlist'] td[class='title']")));
//        selectSong.click();
//        Doesn't work/ why?
//       selectSong.sendKeys(Keys.chord(Keys.DELETE));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectSong).click().sendKeys(Keys.DELETE).perform();
        System.out.println("Song is deleted");
    }
    public String delSongNotificationMsg() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (deleteNotifyLocator));
        String msgText1 = notificationElement.getText();
        System.out.println("Message is: " + msgText1);
        return msgText1;
    }
    // Homework 19: Delete an existing Playlist
    public void selectPlaylist (String Playlist)  {
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(selectedPlaylistLocator)));
        selectedPlaylistElement.click();
        System.out.println("Playlist " + Playlist + " has been selected");
    }
    public void deleteSelectedPlaylist(String Playlist) {
        WebElement deletePlaylistBtnElement = wait.until(ExpectedConditions.elementToBeClickable
                (deletePlaylistBtnLocator));
        deletePlaylistBtnElement.click();
        System.out.println("Playlist " + Playlist + " has been deleted");
    }
    public String getNotificationMsg() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (deleteNotifyLocator));
        String msgText1 = notificationElement.getText();
        System.out.println("Message is: " + msgText1);
       return msgText1;
    }
}