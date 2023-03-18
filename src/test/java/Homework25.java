import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework25 extends BaseTest {


    @Test
    public void registrationNavigation() {

        //GIVEN
        LoginPage loginPage0 = new LoginPage(getDriver());

        //THEN
        loginPage0.clickRegiBtn();

        //WHEN
        Assert.assertEquals(getDriver().getCurrentUrl(), loginPage0.getkoelRegiPage());
    }

    @Test
    public void validLogin1() {

        //GIVEN
        LoginPage loginPage1 = new LoginPage(getDriver());
        HomePage homePage1 = new HomePage(getDriver());

        //THEN
        //loginPage1.inputLogIn(email, password);
        loginPage1.inputEmail(email).inputPassword(password).clickSubmitBtn();

        //WHEN
        Assert.assertTrue(homePage1.isUserAvatarDisplayed().isDisplayed());
    }

}