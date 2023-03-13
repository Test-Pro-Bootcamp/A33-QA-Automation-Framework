package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver submittedDriver) {
        super(submittedDriver);
    }

    public static String updatePlaylist (String playlistToChange, String newPlaylistName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#playlists")));
        String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlistToChange + "')]";
        clickElement(By.xpath(xpathSelector));
        contextClickElement(By.xpath(xpathSelector));
        findElement(By.cssSelector("nav.menu.playlist-item-menu"));
        clickElement(By.cssSelector("li[data-testid *= 'playlist-context-menu-edit']"));
        WebElement newPlaylist = findElement(By.cssSelector("li.playlist.playlist.editing input"));
        newPlaylist.sendKeys(Keys.CONTROL + "a");
        newPlaylist.sendKeys(Keys.DELETE);
        newPlaylist.sendKeys(newPlaylistName);
        newPlaylist.sendKeys(Keys.ENTER);
        String msg = findElement(By.cssSelector("div.success.show")).getText();
        System.out.println(msg);
        return msg;
    }


}
