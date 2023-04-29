import K_pages.HomePage;
import K_pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    //Page Object Model using
    @Test
    public  void LoginSuccessTest () {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail()
                .providePassword()
                .clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
}

//    @Test
//    public static void LoginNotExistingEmailTest () {
//
//        LoginPage loginPage = new LoginPage(getThreadLocal());
//        HomePage homePage = new HomePage(getThreadLocal());
//
//        loginPage.provideEmail("")
//                .providePassword("te$t$tudent")
//                .clickSubmitBtn();
//
//        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
//        driver.quit();
//    }


//    @Test
//    public static void LoginEmptyPasswordTest () {
//
//        LoginPage loginPage = new LoginPage(getThreadLocal());
//        HomePage homePage = new HomePage(getThreadLocal());
//
//        loginPage.provideEmail("krista_ua86@gmail.com");
//        loginPage.providePassword("");
//        loginPage.clickSubmitBtn();
//        Assert.assertTrue(loginPage.isPageOpened());
//
//    }
}