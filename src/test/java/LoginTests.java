import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod

    @Test (enabled = true, description = "This is our first Test for A33 group")
    public void LoginEmptyEmailPasswordTest() {
        openLoginUrl();
       // Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

}
