import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void LoginEmptyEmailPasswordTest() {
        openLoginURL();
        provideEmail("guadalupe.medina@testpro.io");


    }

    private void openLoginURL() {
    }


}




