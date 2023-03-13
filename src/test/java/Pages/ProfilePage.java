package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.UUID;

public class ProfilePage extends BasePage{


    public String newname = getRandomString();
    public String currentname;
    @FindBy(css = "button[class='btn-submit']")
            WebElement savebtnlocator;
    @FindBy(css = "inputProfileNewPassword")
    WebElement newpasswordlocator;
    @FindBy(css = "input[name='current_password']")
    WebElement passwordlocator;
    @FindBy(css = "span[class='name']")
    WebElement profilebnt;
    @FindBy(css = "inputProfileName")
    WebElement profilenamefield;

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private String getRandomString() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void clickSaveBtn(){
        savebtnlocator.click();
    }
    public void clickProfileIcon() {
        profilebnt.click();
    }
    public void setNewPassword() {
        newpasswordlocator.sendKeys("te$t$tudent1");
    }
    public void setCurrentPassword() {
        passwordlocator.sendKeys("te$t$tudent1");
    }
    public void setNewProfileName() {
        profilenamefield.click();
        currentname = profilenamefield.getAttribute("value");
        profilenamefield.clear();
        profilenamefield.sendKeys(newname);
    }

   public boolean validateRenamePlaylist() {
       return newname.equals(currentname);
   }



}
