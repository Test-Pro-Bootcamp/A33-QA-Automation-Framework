import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW16 extends BaseTest{
//    Create a test case, registrationNavigation() using @Test annotation.
//    Using Selenium, navigate to "https://bbb.testpro.io/".
//    Click the Registration link.
//    Verify that you are redirected to Registration page using Assert method.
    @Test
    public void registrationNavigation(){
        WebDriver driver = new ChromeDriver();
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        String registrationPageUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),registrationPageUrl);


}
}
