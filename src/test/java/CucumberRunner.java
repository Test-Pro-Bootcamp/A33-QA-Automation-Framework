import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature","src/test/resources/features/AllSongs.feature","src/test/resources/features/HomeTests.feature",
                "src/test/resources/features/Playlist.feature","src/test/resources/features/Search.feature"},
        glue = {"stepDefinitions"}

)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setupCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}
