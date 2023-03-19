import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public void updateProfileNameTest ()   {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }
}
