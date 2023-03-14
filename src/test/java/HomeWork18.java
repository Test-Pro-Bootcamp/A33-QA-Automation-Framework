import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HomeWork18 extends BaseTest{

    @Test

    public void playSongTest() throws InterruptedException {

        navigateToPage();
        provideEmail("guadalupe.medina@testpro.io");
        providePassword("DoingitBig23!");
        submitButton();


    }
    public void playSong(){
            WebElement playButton = driver.findElement(By.cssSelector("span[@data-testid='play-btn']"));
            WebElement playNextSongButton = driver.findElement(By.cssSelector("i[@data-testid='play-next-btn']"));

            playButton.click();
            playNextSongButton.click();

            Assert.assertTrue(isSongPlaying());

        }


        public boolean isSongPlaying() {
            WebElement soundBarPlay = driver.findElement(By.cssSelector("div[@data-testid ='sound-bar-play']"));
            return soundBarPlay.isDisplayed();



        }








    }



