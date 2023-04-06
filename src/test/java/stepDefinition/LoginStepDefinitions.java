package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

   @Given("I am logged in the Koel")
    public void iAmLoggedInKoel() throws InterruptedException {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
       BaseDefinition.getThreadLocal().get("https://bbb.testpro.io");
        loginPage.provideEmail("test@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Thread.sleep(2000);
    }
    @Given("I open Login Page")
    public void openLoginPage() {
        BaseDefinition.getThreadLocal().get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.clickSubmitBtn();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.isEmailFieldVisible();
    }
}