import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {
    public String newname = getRandomString();
    public String currentname;
    By savebtn = By.cssSelector("button[class='btn-submit']");
    By profilebnt =By.cssSelector("span[class='name']");
    By newpasswordlocator = By.id("inputProfileNewPassword");
    By passwordlocator = By.cssSelector("input[name='current_password']");

    @Test
    public void changeProfileNameTest() {

        openLoginUrl();
        login();
        driver.navigate().to("https://bbb.testpro.io/#!/profile");
        setCurrentPassword();
        setNewProfileName();
        setNewPassword();
        System.out.println("this is new name " + newname);
        System.out.println("this is current " + currentname);
        Assert.assertNotEquals(newname,currentname);
        clickSaveBtn();
    }
    private String getRandomString() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void clickSaveBtn(){
        WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(savebtn));
        savebutton.click();
    }
    public void clickProfileIcon() {
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(profilebnt));
        profile.click();

    }
    public void setNewPassword() {
        WebElement newpasswordfield = wait.until(ExpectedConditions.elementToBeClickable(newpasswordlocator));
        newpasswordfield.sendKeys("te$t$tudent1");
    }
    public void setCurrentPassword() {
        WebElement currentpasswordfield = wait.until(ExpectedConditions.elementToBeClickable(passwordlocator));
        currentpasswordfield.sendKeys("te$t$tudent1");
    }
    public void setNewProfileName() {
        WebElement profilenamefield = driver.findElement(By.id("inputProfileName"));
        profilenamefield.click();
        currentname = profilenamefield.getAttribute("value");
        profilenamefield.clear();
        profilenamefield.sendKeys(newname);
    }
}