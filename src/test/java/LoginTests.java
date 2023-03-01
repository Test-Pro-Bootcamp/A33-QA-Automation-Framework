import org.testng.annotations.Test;

//The following are the Test Cases
public class LoginTests extends BaseTest {

//    @Test(enabled = true, description = "First test for A33")
//    public void LoginEmptyEmailPasswordTest() {
//
//    openLoginUrl();
//    provideEmail("regniermandy@gmail.com");
//    String url = "https://bbb.testpro.io/";

    //Assert.assertEquals(driver.getCurrentUrl(), url);
    //}
    @Test
    public void loginValidEmailValidPasswordTest() {
        openLoginUrl();
        provideEmail("regniermandy@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        exitBrowser();
    }

}
