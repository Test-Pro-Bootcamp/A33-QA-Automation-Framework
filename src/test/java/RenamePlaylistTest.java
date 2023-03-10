import org.testng.annotations.Test;

public class RenamePlaylistTest extends BaseTest {


    @Test

    public void renamePlaylist() {


        // GIVEN user is on the login page ("https://bbb.testpro.io/");
        driver.get(url);
        // AND user puts the correct login and password info
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");
        //AND user clicks a submit button
        clickSubmit();
        doubleClickOnPlaylist();
        provideNewName(":)");



    }

}
