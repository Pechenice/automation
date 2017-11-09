package core;

import helpers.TestHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected enum actions {deleteRepo, resetProfileInfo, closeIssue}

    @BeforeTest
    public void setUp() {
        Driver.init();
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Long.parseLong(PropertiesContainer.get("test.timeout")), TimeUnit.SECONDS);
        Driver.get().get(PropertiesContainer.get("test.baseUrl"));
        TestHelper helper = new TestHelper();
        helper.logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
    }

    @AfterTest
    public void tearDown() {
        clearUp();
        Driver.quit();
    }

    public void clearUp(actions actions) {
        switch (actions) {
            case deleteRepo:

            case closeIssue:

            case resetProfileInfo:
        }
    }
}
