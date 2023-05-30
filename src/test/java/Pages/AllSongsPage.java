package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    @FindBy(xpath = "//*[@id='sidebar']//a[contains(text(),'All Songs')]")
    private WebElement AllSongsPage;
    @FindBy(xpath = "//*[@id='songsWrapper'] //td[contains(text(),'Ketsa - That_s a Beat')]")
    private WebElement chooseSong;
    //@FindBy(xpath = "//*[@id='playlistWrapper']//tr[@class='song-item']//td[contains(text(),'Ketsa - That_s a Beat')]")
    //private WebElement deleteSong1;
    //@FindBy(xpath = "//*[@id='songsWrapper']//li[contains(text(),'Med23')]")
    //private WebElement choosePlaylist1;

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public AllSongsPage redirectToAllSongsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(AllSongsPage)).click();
        return this;
    }
    public AllSongsPage chooseSong(){
        WebElement chooseExistSong =wait.until(ExpectedConditions.visibilityOf(chooseSong));
        actions.contextClick(chooseExistSong).perform();
        return this;
    }
    public AllSongsPage hoverOverToAddTo() {
        WebElement AddToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']//li[contains(text(),'Add To')]")));
        actions.moveToElement(AddToButton).perform();
        return this;
    }
        public AllSongsPage hoverOverTOPlaylist(){
            WebElement AddToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//ul[@class='menu submenu menu-add-to']//li[contains(text(),'Med23')]"))) ;
            actions.moveToElement(AddToButton).perform();
            return  this;
    }
    public AllSongsPage clickPlaylist() {
        WebElement AddToButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//ul[@class='menu submenu menu-add-to']//li[contains(text(),'Med23')]")));
        actions.doubleClick(AddToButton).perform();
        return this;
    }
    //public AllSongsPage choosePlaylist(){
      // wait.until(ExpectedConditions.visibilityOf(choosePlaylist1)).click();
        //return this;
    //}
    public boolean songAddedMsgDisplayed(){
        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage.isDisplayed();
    }
    public AllSongsPage deleteSongFromPlaylist(){
    WebElement clickSong= wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//section[@id='playlistWrapper']//td[contains(text(),'Ketsa - That_s a Beat')]")));
    clickSong.click();
    actions.sendKeys(Keys.DELETE).perform();

        return this;
    }
    public boolean notificationSongDeleted(){
        WebElement getNotificationMessage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage1.isDisplayed();
    }
}
