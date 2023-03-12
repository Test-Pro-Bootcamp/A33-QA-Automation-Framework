import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void renamePlaylist(){
        LoginPage logIntoProfile = new LoginPage(driver);
        HomePage newPlayListName = new HomePage(driver);


        logIntoProfile.logIn();
        newPlayListName.clickPlayList();
        newPlayListName.chooseEdit();
        newPlayListName.renamePlayListName();

        Assert.assertTrue(HomePage.verifyNewPlayListName());
    }
}