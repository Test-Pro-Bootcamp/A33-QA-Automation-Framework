import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {


    }

    @Test
    public void LoginValidEmailPasswordTest() {
        provideEmail();
        providePassword();
        submitButton();



    }

}
