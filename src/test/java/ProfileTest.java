import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {
    public String newname = getRandomString();
    public String currentname;


    @Test
    public void changeProfileNameTest() throws InterruptedException {

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
        WebElement savebutton = driver.findElement(By.cssSelector("button[class='btn-submit']"));
        savebutton.click();
    }

    public void clickProfileIcon() {
        WebElement profile = driver.findElement(By.cssSelector("span[class='name']"));
        profile.click();

    }

    public void setNewPassword() {
        WebElement newpasswordfield = driver.findElement(By.id("inputProfileNewPassword"));
        newpasswordfield.sendKeys("te$t$tudent1");
    }

    public void setCurrentPassword() {
        WebElement currentpasswordfield = driver.findElement(By.cssSelector("input[name='current_password']"));
        currentpasswordfield.sendKeys("te$t$tudent1");
    }

    public void setNewProfileName() {
        WebElement profilenamefield = driver.findElement(By.id("inputProfileName"));
        profilenamefield.click();
        currentname = profilenamefield.getAttribute("value");
        profilenamefield.clear();
        profilenamefield.sendKeys(newname);
    }


//delete later


}