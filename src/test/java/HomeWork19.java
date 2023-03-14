import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomeWork19 extends BaseTest{

    @Test
    public void DeletePlaylist() throws InterruptedException {
        login();
        openPlayList();
        deletePlaylist();

        WebElement deletePlaylistMsg = getDeletedPlaylistMsg();
        Assert.assertTrue(deletePlaylistMsg.isDisplayed());
    }

    private void login() throws InterruptedException {
    provideEmail("guadalupe.medina@testpro.io");
    providePassword("DoingitBig23!");
    submitButton();
    }


    public WebElement getDeletedPlaylistMsg(){
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    public void openPlayList() throws InterruptedException{
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(2000);


    }
    private void deletePlaylist() throws InterruptedException{
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        Thread.sleep(2000);

    }


}


