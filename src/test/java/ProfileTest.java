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
        clickSaveBtn();
        System.out.println(newname);
        System.out.println(currentname);
        Assert.assertNotEquals(newname,currentname);



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
        currentname = profilenamefield.getText();

        profilenamefield.clear();
        profilenamefield.sendKeys(newname);
    }


//delete later

    public void openLoginUrl() {
        String url = "https://bbb.testpro.io";
        driver.get(url);
    }
    public void enterEmail(String email) {
        WebElement emailfield = driver.findElement(By.cssSelector("input[type='email']"));
        emailfield.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
        passwordfield.sendKeys(password);
    }

    public void submit() {
        WebElement submitbtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitbtn.click();
    }

    public void login() {
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
    }
}