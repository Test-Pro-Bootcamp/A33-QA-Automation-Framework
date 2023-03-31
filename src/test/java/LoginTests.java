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
    public static void LoginSuccessTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("krista_ua86@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        driver.quit();
    }


    @Test
    public static void LoginNotExistingEmailTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("notExisting@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();
    }



    @Test
    public static void LoginEmptyPasswordTest() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("krista_ua86@gmail.com");
        loginPage.clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();
    }
}