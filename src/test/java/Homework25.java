import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework25 extends BaseTest {


    @Test
    public void validLogin1() {

        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //THEN
        //loginPage1.inputLogIn(email, password);
        loginPage.inputEmail(email).inputPassword(password).clickSubmitBtn();

        //WHEN
        Assert.assertTrue(homePage.isUserAvatarDisplayed().isDisplayed());
    }

    @Test
    public void validLogin2() {

        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //THEN
        //loginPage1.inputLogIn(email, password);
        loginPage.inputEmail(email).inputPassword(password).clickSubmitBtn();

        //WHEN
        Assert.assertTrue(homePage.isUserAvatarDisplayed().isDisplayed());
    }

    @Test
    public void validLogin3() {

        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //THEN
        //loginPage1.inputLogIn(email, password);
        loginPage.inputEmail(email).inputPassword(password).clickSubmitBtn();

        //WHEN
        Assert.assertTrue(homePage.isUserAvatarDisplayed().isDisplayed());
    }

}