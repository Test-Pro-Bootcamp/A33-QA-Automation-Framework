package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchPage extends BasePage {
    @FindBy(css = "[type='search']")
    private WebElement searchField;
    @FindBy(xpath = "//ul/article/span")
    private WebElement songDisplayAfterSearch;
    @FindBy(xpath = "//section[@class='artists']/ul")
    private WebElement artistDisplayAfterSearch;
    @FindBy(xpath = "//section[@class='albums']/ul/li")
    private WebElement albumDisplayAfterSearch;
    By searchResultText = By.xpath("//*[@id='searchExcerptsWrapper']/header/div[2]/h1/span");
    public SearchPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public SearchPage typeSearchQuery(String query)  {
//        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(query);
        return this;
    }
    public void songIsDisplayed(){
        Assert.assertTrue(songDisplayAfterSearch.isDisplayed());
    }
    public void artistIsDisplayed(){
        Assert.assertTrue(artistDisplayAfterSearch.isDisplayed());
    }

    public void albumIsDisplayed(){
        Assert.assertTrue(albumDisplayAfterSearch.isDisplayed());
    }
}
