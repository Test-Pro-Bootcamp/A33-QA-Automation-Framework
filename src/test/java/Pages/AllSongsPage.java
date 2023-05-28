package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    @FindBy(xpath = "//*[@id='sidebar']//a[contains(text(),'All Songs')]")
    private WebElement AllSongsPage;
    @FindBy(xpath = "//*[@id='songsWrapper'] //td[contains(text(),'Ketsa - That_s a Beat')]")
    private WebElement chooseSong;
    @FindBy(xpath = "//*[@id='app']//li[contains(text(),'Add To')]")
    private WebElement chooseAddTo;
    @FindBy(xpath = "//*[@id='songsWrapper']//li[contains(text(),'Med')]")
    private WebElement choosePlaylist1;

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
    public AllSongsPage hoverOverTOPlaylist(){
        WebElement AddToButton =wait.until(ExpectedConditions.visibilityOf(chooseAddTo));
        actions.moveToElement(AddToButton).perform();
        return  this;
    }
    public AllSongsPage choosePlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(choosePlaylist1)).click();
        return this;
    }
    public boolean songAddedMsgDisplayed(){
        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage.isDisplayed();
    }
}
