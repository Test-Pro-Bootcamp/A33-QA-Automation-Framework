import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {
    ProfilePage profilepage = new ProfilePage(driver);
    LoginPage loginpage = new LoginPage(driver);


    @Test
    public void changeProfileNameTest() {
        loginpage.login();
        profilepage.clickProfileIcon(); //test if this method works
        profilepage.setCurrentPassword();
        profilepage.setNewProfileName();
        profilepage.setNewPassword();

        //System.out.println("this is new name " + newname);
        //System.out.println("this is current " + currentname);
        Assert.assertTrue(validateRenamePlaylist());
        profilepage.clickSaveBtn();
    }

}