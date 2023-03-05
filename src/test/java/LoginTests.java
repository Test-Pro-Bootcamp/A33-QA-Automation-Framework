import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = false, dataProvider = "incorrectLoginData")
    public void LoginIncorrectCredentials(String email, String password) throws InterruptedException {
        // navigateToPage("https://bbb.testpro.io/");
        driver.get(url);
        // Login to the Homepage Koel
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);


        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}
