import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReport {
    ExtentReports extent = null;

    @BeforeTest
    public void config(){
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        System.out.println(path);
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Masaru Kunihiro");

    }
    @Test
    public void initialDemo() {
        extent.createTest("Initial Demo");
        WebDriver driver = new ChromeDriver();
        driver.get("https://bbb.testpro.io/");
        System.out.println(driver.getTitle());
        extent.flush();
    }
}
