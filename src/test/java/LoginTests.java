import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

// import static java.lang.System.getenv;


public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailValidPasswordTest() {

        openLoginURL();
        inputEmail(System.getenv("Email"));
        inputPassword(System.getenv("Password"));
        clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(koelHome));

        //Assert.assertEquals(driver.getCurrentUrl(), koelHome);
    }


}
