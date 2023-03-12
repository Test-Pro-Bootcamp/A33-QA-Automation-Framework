import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.LoginPage;
import pages.HomePage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("regniermandy@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("regniermandy@gmail.com");
        loginPage.providePassword("");
        loginPage.clickSubmitButton();
        Assert.assertEquals(url, url);
    }
    @Test
    public void loginIncorrectEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("regniermandy@gmail.com");
        loginPage.providePassword("incorrectpassword");
        loginPage.clickSubmitButton();
        Assert.assertEquals(url, url);
    }
}


//  These are the old TESTS
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//
//        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
//        emailField.sendKeys("regniermandy@gmail.com");
//
//        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//        submitButton.click();
//        //Assert.assertTrue();
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
 //   }
//    public static void LoginSuccessTest() {
//    //GIVEN Pre-condition: Chrome should be opened
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//
//        //Locate web element for the email field by css selector
//        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
//        emailField.sendKeys("regniermandy@gmail.com");
//
//        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//        passwordField.click();
//        passwordField.sendKeys("te$t$tudent");
//
//        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//        submitButton.click();
//
//        WebElement usersAvatar = driver.findElement(By.xpath(("[alt='Avatar of student']")));
//        Assert.assertTrue(usersAvatar.isDisplayed());
//        driver.quit();
//    }

