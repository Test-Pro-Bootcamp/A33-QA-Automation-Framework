import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.openqa.selenium.By.cssSelector;

public class Homework22 extends BaseTest{

    @Test//(dataProvider = "loginData")
    public void renamePlaylist(){
        LoginPage logIntoProfile = new LoginPage(driver);
        HomePage newPlayListName = new HomePage(driver);


        logIntoProfile.enterEmail("linulya1411@gmail.com");
        logIntoProfile.enterPassword("te$t$tudent");
        logIntoProfile.clickSubmit();
        newPlayListName.clickPlayList();
        newPlayListName.chooseEdit();
        newPlayListName.renamePlayListName("New Playlist");

        Assert.assertTrue(verifyNotification());
    }
    public boolean verifyNotification(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        WebElement messageElement = driver.findElement(By.cssSelector("div.success.show"));
        return messageElement.isDisplayed();
    }
}