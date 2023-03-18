import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test(enabled = true, description = "Homework16 and isnt needed for hw17")
    public void registrationNavigation() {

        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());

        //THEN
        loginPage.clickRegiBtn();

        //WHEN
        Assert.assertEquals(getDriver().getCurrentUrl(), loginPage.getkoelRegiPage());
    }
}
