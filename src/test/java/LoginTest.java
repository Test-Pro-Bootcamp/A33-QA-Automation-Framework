import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithValidEmail() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.loginPageTest();
        //THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginWithInvalidEmail() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.loginWithInvalidEmail();
        //THEN
        Assert.assertEquals(url, url);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.loginWithInvalidPassword();
        //THEN
        Assert.assertEquals(url, url);
    }

    @Test(dataProvider = "getData")
    public void loginWithMultipleAccount(HashMap<String,String> input) {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.loginApplication(input.get("email"), input.get("password"));

    }
    @DataProvider
    public Object[][] getData(){
        HashMap<String,String> map = new HashMap<>();
        map.put("email", "test@test.com");
        map.put("password", "te$t$tudent");

        HashMap<String,String> map2 = new HashMap<>();
        map.put("email", "test@test.com");
        map.put("password", "te$t$tudent");

        return new Object[][]{{map},{map2}};

    }
}