package pages.stepDefinitions;

import org.junit.AfterClass;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"})


public class CucumberRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @DataProviderpublic
    Object[][] features() {

        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();

    }
}
