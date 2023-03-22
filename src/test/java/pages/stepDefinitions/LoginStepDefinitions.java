package pages.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinitions {


    WebDriver driver;
    WebDriverWait wait;

    @Given("I open browser")
    public void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @When("I enter email {string}")
    public void iEnterEmail(String arg0) {

    }

    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {

    }

    @And("I submit")
    public void iSubmit() {

    }

    @Then("I am logged in")
    public void iAmLoggedIn() {

    }
}