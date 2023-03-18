import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {


    }

    @Test
    public void LoginInValidEmailPasswordTest() {
        provideEmail();
        providePassword();
        submitButton();



    }

}
